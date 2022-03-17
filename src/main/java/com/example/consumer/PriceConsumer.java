package com.example.consumer;

import io.smallrye.reactive.messaging.kafka.api.IncomingKafkaRecordMetadata;
import java.util.concurrent.CompletionStage;
import javax.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

@ApplicationScoped
public class PriceConsumer {

//    @Incoming("prices")
//    public void consume(double price) {
//        // process your price.
//    }
//
//    @Incoming("prices")
//    public CompletionStage<Void> consume(Message<Double> msg) {
//        // access record metadata
//        var metadata = msg.getMetadata(IncomingKafkaRecordMetadata.class).orElseThrow();
//        // process the message payload.
//        double price = msg.getPayload();
//        // Acknowledge the incoming message (commit the offset)
//        return msg.ack();
//    }
//
//    @Incoming("prices")
//    public void consume(ConsumerRecord<String, Double> record) {
//        String key = record.key(); // Can be `null` if the incoming record has no key
//        String value = String.valueOf(record.value()); // Can be `null` if the incoming record has no value
//        String topic = record.topic();
//        int partition = record.partition();
//        // ...
//    }

//    @Incoming("prices")
//    public CompletionStage<Void> consume(Message<Double> msg) {
//        // access record metadata
//        var metadata = msg.getMetadata(IncomingKafkaRecordMetadata.class).orElseThrow();
//        // process the message payload.
//        double price = msg.getPayload();
//        // Acknowledge the incoming message (commit the offset)
//        return msg.ack();
//    }
}