package org.mumu.Service;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.MailTemplate;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.quarkus.qute.Location;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MailService {

    @Inject
    ReactiveMailer reactiveMailer;

    @Inject
    @Location("emailFarm")
    MailTemplate emailFarm;

    public Uni<Void> sendMailFarm(){
        return emailFarm.to("muhaiminmuhyi@gmail.com")
                .subject("Report Monthly Farmer")
                .data("name", "Dengklek")
                .send();
    }
}
