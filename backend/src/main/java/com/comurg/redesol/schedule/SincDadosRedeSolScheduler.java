package com.comurg.redesol.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SincDadosRedeSolScheduler {

    //@Scheduled(cron = "0 0 12 * * ?") Todos os dias as 12h
    @Scheduled(cron = "0 0/1 * * * *")
    public void initSchedule() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }
}
