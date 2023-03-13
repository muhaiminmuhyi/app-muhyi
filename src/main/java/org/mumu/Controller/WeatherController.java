package org.mumu.Controller;

import io.vertx.core.json.JsonObject;
import net.sf.jasperreports.engine.JasperPrint;
import org.mumu.Models.Weather;
import org.mumu.Service.WeatherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("weather")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WeatherController {

    @Inject
    WeatherService weatherService;

    @GET
    public List<Weather> getWeather() {
        return weatherService.weatherList();
    }

    @GET
    @Path("pdf")
    public void pdfWeather() throws Exception { weatherService.weatherPdf(); }

    @GET
    @Path("all/{city}")
    public List<Weather> getListAllByCity(@PathParam("city") String city) {return weatherService.weatherAll(city); }

    @GET
    @Path("{time}")
    public Object getWeatherByCity(@PathParam("time") String time) {
        return weatherService.getWeatherCity(time);
    }

    @DELETE
    @Path("{time}")
    public Response deleteWeather(@PathParam("time") String time) {
        return weatherService.deleteWeather(time);
    }

    @POST
    public Response postWeather(JsonObject body){
        return weatherService.postWeather(body);
    }

    @PUT
    @Path("{time}")
    public Response putWeather(@PathParam("time") String time, JsonObject body){
        return weatherService.putWeather(time, body);
    }

}
