package bstu.by.lisunkova.server_healthtracker;

import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.CommonMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerHealthtrackerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServerHealthtrackerApplication.class, args);
    }

}
