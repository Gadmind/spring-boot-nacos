package com.daop.nacos.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @BelongsProject: spring-cloud-nacos
 * @BelongsPackage: com.daop.nacos.consumer.service
 * @Description:
 * @DATE: 2020-09-28
 * @AUTHOR: Administrator
 **/
@FeignClient("nacos-provider")
public interface EchoService {
    /**
     * 测试
     * @param message 接口信息
     * @return 回调信息
     */
    @GetMapping("/echo/{string}")
    String echo(@PathVariable("string") String message);
}
