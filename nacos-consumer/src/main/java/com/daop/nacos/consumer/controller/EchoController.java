package com.daop.nacos.consumer.controller;

import com.daop.nacos.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: spring-cloud-nacos
 * @BelongsPackage: com.daop.nacos.consumer.controller
 * @Description: 控制器
 * @DATE: 2020-09-28
 * @AUTHOR: Administrator
 **/
@RestController
public class EchoController {
//    private final RestTemplate restTemplate;
    @Value("${params.name}")
    private String paramsName;

    @Value("${params.desc}")
    private String paramsDesc;


    /*@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Autowired
    public EchoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    @Autowired
    private EchoService echoService;

 /*   @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://nacos-provider/echo/" + str, String.class) + "\tParamsName:" + paramsName + "\tparamsDesc:" + paramsDesc;
    }*/

    @GetMapping("/feign/echo/{message}")
    public String feignEcho(@PathVariable("message") String message) {
        return echoService.echo(message);
    }
}
