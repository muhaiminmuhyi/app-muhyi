package org.mumu.Service;

import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SchedulerService {

    @Inject
    FarmService farmService;

    @Scheduled(cron="00 06 * * 6")
    void scheduleFarm() {
        farmService.postFarm();
    }

    @Scheduled(cron = "00 06 31 * *")
    void generatePdf() throws Exception {farmService.farmPdf();}
}
