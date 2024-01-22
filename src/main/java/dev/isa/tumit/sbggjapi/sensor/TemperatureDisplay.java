package dev.isa.tumit.sbggjapi.sensor;

import java.util.concurrent.Flow;

public class TemperatureDisplay implements Flow.Subscriber<Double> {

    private final CelsiusConverter converter;
    private Flow.Subscription subscription;

    public TemperatureDisplay(CelsiusConverter converter) {
        this.converter = converter;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Double item) {
        var converted = converter.convert(item);
        System.out.printf("%s%n", converted);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }
}
