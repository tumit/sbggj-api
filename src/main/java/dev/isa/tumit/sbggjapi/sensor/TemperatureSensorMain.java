package dev.isa.tumit.sbggjapi.sensor;

public class TemperatureSensorMain {

    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.start();
        sensor.asPublisher().subscribe(new TemperatureDisplay(new CelsiusConverter()));
    }
}
