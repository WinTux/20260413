package com.pepe.consumer;

import com.pepe.consumer.Modelos.RegistroWikimedia;
import com.pepe.consumer.Repositorios.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDDBBconsumer {
    private WikimediaRepository wikiRepo;
    private static final Logger logger = LoggerFactory.getLogger(KafkaDDBBconsumer.class);

    public KafkaDDBBconsumer(WikimediaRepository wikiRepo) {
        this.wikiRepo = wikiRepo;
    }

    @KafkaListener(topics = "recentchange_de_wikimedia", groupId = "miGrupo")
    public void consumir(String mensaje){
        logger.info(String.format("Mensaje recibido en KafkaDDBBconsumer: %s", mensaje));
        RegistroWikimedia registro =  new RegistroWikimedia();
        registro.setDatos(mensaje);
        wikiRepo.save(registro);
    }
}
