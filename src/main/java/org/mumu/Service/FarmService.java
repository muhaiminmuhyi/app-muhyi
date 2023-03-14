package org.mumu.Service;


import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.mumu.Exception.CustomException;
import org.mumu.Models.Farmers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@ApplicationScoped
public class FarmService {

    @ConfigProperty(name = "app-muhyi.custom.error.msg.notfound")
    String notFound;

    @Inject
    JasperReportGeneratorService jasperReportGeneratorService;
    public void farmPdf() throws Exception {
        LocalDate pdfDate = LocalDate.now();
        String fileName = "reportOfFarm" + "_" + pdfDate.toString() + ".pdf";
        String outputFileName = "external_resources/generatedReport/" + fileName;
        String jasperReportPath = "external_resources/jasperReport/templateFarm.jrxml";
        jasperReportGeneratorService.generatePdfReport(jasperReportPath, outputFileName);
    }

    @Transactional
    public void postFarm() {
        Farmers farmers = new Farmers();
        LocalDate currentDate = LocalDate.now();

        farmers.komoditas = "Tomat";
        farmers.total = 500;
        farmers.isChecked = false;
        farmers.createdAt = currentDate;
        farmers.updatedAt = currentDate;
        farmers.persist();
    }

    @Transactional
    public Response putFarm(String date, JsonObject body) {
        if (date == null){
            throw new CustomException(notFound);
        }
        Boolean isChecked = body.getBoolean("isChecked");
        Farmers.update("ischecked=?1 where createdat=?2", isChecked, LocalDate.parse(date));
        return Response.ok().entity("Successfully").build();
    }

}
