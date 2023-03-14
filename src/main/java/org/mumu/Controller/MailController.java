package org.mumu.Controller;

import io.smallrye.mutiny.Uni;
import org.mumu.Service.MailService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("mail")
public class MailController {

    @Inject
    MailService mailService;

    @GET
    @Path("farm")
    public Uni<Void> sendMailFarm(){
        return mailService.sendMailFarm();
    }
}
