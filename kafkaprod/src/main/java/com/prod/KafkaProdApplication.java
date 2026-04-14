package com.prod;

import com.prod.kfk.RecentchangeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProdApplication implements CommandLineRunner {
    @Autowired
    private RecentchangeProducer cambios;
    public static void main(String[] args) {
        SpringApplication.run(KafkaProdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cambios.enviarMensaje();
    }
}
