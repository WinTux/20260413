package com.prod.kfk;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.prod.RecentchangeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class RecentchangeProducer {
    private static final Logger logger = LoggerFactory.getLogger(RecentchangeProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public RecentchangeProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void enviarMensaje() throws InterruptedException{
        String topic = "recentchange_de_wikimedia";
        // Leer datos en tiempo real
        BackgroundEventHandler event = new RecentchangeHandler(kafkaTemplate,topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(event, new EventSource.Builder(URI.create(url)));
        BackgroundEventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(5);
    }
}
