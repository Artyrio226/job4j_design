package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        String name = "Petr Arsentev";
        byte age = 33;
        short height = 180;
        int weight = 83;
        long id = 57893300;
        float distance = 412.49F;
        double average = 84.2;
        char group = 'G';
        boolean married = true;
        LOG.debug("User info name : {}"
                        + ", age : {}"
                        + ", height : {}"
                        + ", weight : {}"
                        + ", id : {}"
                        + ", distance : {}"
                        + ", average : {}"
                        + ", group : {}"
                        + ", married : {}",
                name,
                age,
                height,
                weight,
                id,
                distance,
                average,
                group,
                married);
    }
}
