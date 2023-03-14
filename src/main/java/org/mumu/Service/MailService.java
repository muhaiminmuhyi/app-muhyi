package org.mumu.Service;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.MailTemplate;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.quarkus.qute.Location;
import io.quarkus.scheduler.Scheduled;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.time.LocalDate;

@ApplicationScoped
public class MailService {

    @Inject
    ReactiveMailer reactiveMailer;

    @Inject
    @Location("emailFarm")
    MailTemplate emailFarm;

    @Scheduled(cron="00 07 31 * *")
    public Uni<Void> sendMailFarm(){
        LocalDate pdfDate = LocalDate.now();
        return emailFarm.to("muhaiminmuhyi@gmail.com")
                .subject("Report Monthly Farmer")
                .data("name", "Dengklek")
                .addAttachment("ReportFarmMonthly.pdf", new File("external_resources/generatedReport/reportOfFarm_"+pdfDate+".pdf"),"application/pdf")
                .send();
    }
}
