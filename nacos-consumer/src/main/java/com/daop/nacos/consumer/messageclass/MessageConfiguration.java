package com.daop.nacos.consumer.messageclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring-cloud-nacos
 * @BelongsPackage: com.daop.nacos.consumer.messageclass
 * @Description:
 * @DATE: 2020-10-09
 * @AUTHOR: Administrator
 **/
@Component
@EnableBinding({Source1.class, Source2.class})
public class MessageConfiguration {
    @Autowired
    private Source1 source1;

    @Bean
    public CommandLineRunner runner() {
        return (args) ->
                source1.output()
                        .send(MessageBuilder.withPayload("custom payload")
                                .setHeader("k1", "v1").build());
    }

    @StreamListener("source1")
    @SendTo("source2")
    public String receiveFromSource2(String msg) {
        System.out.println("receive msg from source1 " + msg);
        return msg.toUpperCase();
    }

    @StreamListener("source2")
    public void receiveFromRocketMQ(String msg) {
        System.out.println("receive msg from source2 " + msg);
    }

}
