package com.pepe.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDDBBconsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaDDBBconsumer.class);
    @KafkaListener(topics = "recentchange_de_wikimedia", groupId = "miGrupo")
    public void consumir(String mensaje){
        logger.info(String.format("Mensaje recibido en KafkaDDBBconsumer: %s", mensaje));
    }
}
