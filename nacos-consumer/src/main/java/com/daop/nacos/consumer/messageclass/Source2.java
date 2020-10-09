package com.daop.nacos.consumer.messageclass;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @BelongsProject: spring-cloud-nacos
 * @BelongsPackage: com.daop.nacos.consumer.messageclass
 * @Description:
 * @DATE: 2020-10-09
 * @AUTHOR: Administrator
 **/
public interface Source2 {
    @Output("source2")
    MessageChannel output();

    @Input("source2")
    SubscribableChannel input();
}
