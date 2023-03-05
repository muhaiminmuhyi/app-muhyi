package org.mumu.Service;

import io.vertx.core.json.JsonObject;
import org.mumu.Models.Category;
import org.mumu.Models.Summary;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SummaryService {

    public List<Summary> summaryList(){
        return Summary.listAll();
    }

    @Transactional
    public Summary summaryPost(JsonObject body){
        Summary summary = new Summary();
        summary.name_summary = body.getString("name");
        summary.persist();
        return summary;
    }

    public Summary summaryGetByName(String name_summary){
        return Summary.find("name_summary = ?1", name_summary).firstResult();
    }

}
