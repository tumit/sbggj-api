package dev.isa.tumit.sbggjapi.sensor;

public class CelsiusConverter {

    public Double convert(Double temp) {
        return temp * 1.8 + 32;
    }
}
