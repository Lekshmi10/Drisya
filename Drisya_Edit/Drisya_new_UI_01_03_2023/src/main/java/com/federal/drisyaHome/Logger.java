package com.federal.drisyaHome;

import org.apache.logging.log4j.LogManager;

public class Logger {

    public static Logger logger = new Logger();
    public static org.apache.logging.log4j.Logger logger4j;

    public static void error(String error){

        logger4j = LogManager.getLogger(Logger.class);
        logger4j.error(error);

    }

}
