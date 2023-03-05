package org.mumu.Service;



import com.oracle.svm.core.annotate.Inject;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import org.mumu.Exception.CustomException;
import org.mumu.Models.Weather;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ApplicationScoped
public class WeatherService {

    CategoryService categoryService = new CategoryService();
    SummaryService summaryService = new SummaryService();

    @Inject
    Logger log;

    @ConfigProperty(name = "app-muhyi.custom.error.msg.notfound")
    String notFound;

    @ConfigProperty(name = "app-muhyi.custom.error.msg.internalservererror")
    String internErr;


    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("HH:mm:ss");


    public List<Weather> weatherList(){
       return Weather.listAll();
    }

    public Object getWeatherCity(String time){
        Weather weather = Weather.find("time = ?1", LocalTime.parse(time)).firstResult();
        if (weather == null){
            throw new CustomException(notFound);
        }
        return weather;
    }

    public List<Weather> weatherAll(String city){
        return Weather.list("city", city);
    }

    @Transactional
    public Response postWeather(JsonObject body) throws CustomException {
        Weather weather = new Weather();
        String name_category = body.getString("category");
        String name_summary = body.getString("summary");
        String formatTime = currentTime.format(newFormat);

        weather.city = body.getString("city");
        weather.tempLow = body.getInteger("tempLow");
        weather.tempHigh = body.getInteger("tempHigh");
        weather.humidity = body.getFloat("humidity");
        weather.windSpeed = body.getFloat("windSpeed");
        weather.windBearing = body.getFloat("windBearing");
        weather.visibility = body.getFloat("visibility");
        weather.date = currentDate;
        weather.time = LocalTime.parse(formatTime);
        weather.category = categoryService.categoryGetByName(name_category);
        weather.summary = summaryService.summaryGetByName(name_summary);
        if (weather.category == null){
            throw new CustomException(notFound);
        }
        if (weather.summary == null){
            throw new CustomException(notFound);
        }
        weather.persist();
        return Response.ok().entity("Successfully").build();
    }

    @Transactional
    public Response putWeather(String time, JsonObject body){
        if (time == null){
            throw new CustomException(notFound);
        }
        Integer newtempLow = body.getInteger("tempLow");
        Integer newtempHigh = body.getInteger("tempHigh");
        Float newHumidity = body.getFloat("humidity");
        Float newWindSpeed = body.getFloat("windSpeed");
        Float newWindBearing = body.getFloat("windBearing");
        Float newVisibility = body.getFloat("visibility");
        Weather.update("templow = ?1, temphigh = ?2, humidity=?3, windspeed=?4, windbearing=?5, visibility=?6 where time=?7", newtempLow, newtempHigh,newHumidity,newWindSpeed,newWindBearing,newVisibility, LocalTime.parse(time));
        return Response.ok().entity("Successfully").build();
    }

    @Transactional
    public Response deleteWeather(String time){
        Weather.delete("time=?1", LocalTime.parse(time));
        return Response.ok().entity("Successfully").build();
    }
}
