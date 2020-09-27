package com.daop.nacos.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @RestController
    class TestController {
        private final RestTemplate restTemplate;

        @Value("${params.name}")
        private String paramsName;

        @Value("${params.desc}")
        private String paramsDesc;

        @Autowired
        public TestController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @GetMapping("/echo/{str}")
        public String echo(@PathVariable String str) {
            return restTemplate.getForObject("http://nacos-provider/echo/" + str, String.class)+"\tParamsName:"+paramsName+"\tparamsDesc:"+paramsDesc;
        }
    }
}
