package aqa_exam.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
    protected static final Logger LOGGER = LogManager.getLogger(MyLogger.class);

    public static void main(String[] args) {
        LOGGER.debug("debug message");
        LOGGER.info("info message");
        LOGGER.warn("warning message");
    }
}
