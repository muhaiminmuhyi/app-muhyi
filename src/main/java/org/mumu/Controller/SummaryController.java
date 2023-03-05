package org.mumu.Controller;

import io.vertx.core.json.JsonObject;
import org.mumu.Models.Summary;
import org.mumu.Service.SummaryService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("summary")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SummaryController {
    @Inject
    SummaryService summaryService;

    @GET
    public List<Summary> getSummary(){
        return summaryService.summaryList();
    }

    @POST
    public Summary postSummary(JsonObject body){
        return summaryService.summaryPost(body);
    }
}
