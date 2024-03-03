package com.dev.cicd.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public final class DataApplication {

    private DataApplication() {
        // Private constructor to prevent instantiation
    }

    /**
     * Main method to start the DataApplication.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

}
