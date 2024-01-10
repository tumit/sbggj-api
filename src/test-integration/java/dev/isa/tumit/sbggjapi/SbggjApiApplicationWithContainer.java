package dev.isa.tumit.sbggjapi;

import org.springframework.boot.SpringApplication;

public class SbggjApiApplicationWithContainer {

    public static void main(String[] args) {
        var app = new SpringApplication(SbggjApiApplication.class);
        app.addInitializers(new AbstractContainerTest.Initializer());
        app.run(args);
    }
}
