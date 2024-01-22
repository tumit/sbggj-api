package dev.isa.tumit.sbggjapi.sensor;

import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;


public class TemperatureSensor {

    private final SubmissionPublisher<Double> publisher;
    private final Random random;

    public TemperatureSensor() {
        this.publisher = new SubmissionPublisher<>();
        this.random = new Random();
    }

    public void start() {
        Thread thread = new Thread(() -> {
            while (true) {
                double temperature = random.nextDouble() * 100;
                publisher.submit(temperature);
                sleep(random.nextInt(500));
            }
        });
        thread.start();
    }

    public void stop() {
        publisher.close();
    }

    public Flow.Publisher<Double> asPublisher() {
        return publisher;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
