package com.example.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExampleScheduler {

    private static Logger logger = LoggerFactory.getLogger(ExampleScheduler.class);

    @Scheduled(cron = "0 0/1 * * * *")
    public void initSchedule() {
        logger.info("Java cron job executed.");
    }
}
