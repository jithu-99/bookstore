package com.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Jithendra Chikkanna
 */
@SpringBootApplication
public class Application {

    /**
     * Logger instance.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * Application main entry point.
     *
     * @param args Command line arguments.
     */
    public static void main(final String... args) {
        LOGGER.info("A new instance of the bookstore is warming up ...");

        SpringApplication.run(Application.class, args);

    }

}
