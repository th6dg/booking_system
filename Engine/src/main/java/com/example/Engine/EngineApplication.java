package com.example.Engine;

import com.example.Engine.service.room.Impl.RoomFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;

@SpringBootApplication(exclude = FlywayAutoConfiguration.class)
public class EngineApplication {

	public static void main(String[] args) {

		SpringApplication.run(EngineApplication.class, args);

	}

}
