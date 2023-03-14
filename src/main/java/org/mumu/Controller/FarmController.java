package org.mumu.Controller;

import io.vertx.core.json.JsonObject;
import org.mumu.Service.FarmService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("farm")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FarmController {

    @Inject
    FarmService farmService;

    @GET
    public void pdfWeather() throws Exception{
        farmService.farmPdf();
    }

    @PUT
    @Path("{date}")
    public Response putFarm(@PathParam("date") String date, JsonObject body){
        return farmService.putFarm(date, body);
    }
}
