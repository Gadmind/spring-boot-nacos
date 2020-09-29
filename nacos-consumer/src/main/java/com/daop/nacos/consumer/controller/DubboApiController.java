package com.daop.nacos.consumer.controller;

import com.daop.dubbo.api.DubboEchoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: spring-cloud-nacos
 * @BelongsPackage: com.daop.nacos.consumer.controller
 * @Description: DubboAPI调用请求 通过cloud-Dubbo进行远程服务调用
 * @DATE: 2020-09-28
 * @AUTHOR: Administrator
 **/
@RestController
public class DubboApiController {
    @DubboReference
    private DubboEchoService echoService;

    @GetMapping("/dubbo/echo/{msg}")
    public String dubboEcho(@PathVariable("msg") String msg) {
        return echoService.echoService(msg);
    }
}
