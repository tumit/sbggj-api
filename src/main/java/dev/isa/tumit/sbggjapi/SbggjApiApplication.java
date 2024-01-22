package dev.isa.tumit.sbggjapi;

import dev.isa.tumit.sbggjapi.sensor.CelsiusConverter;
import dev.isa.tumit.sbggjapi.sensor.TemperatureDisplay;
import dev.isa.tumit.sbggjapi.sensor.TemperatureSensor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbggjApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbggjApiApplication.class, args);
	}

}
