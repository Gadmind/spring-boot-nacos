package com.daop.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动类
 *
 * @author Administrator
 */
//开启服务注册发现功能
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @RestController
    class EchoController {
        @GetMapping("/echo/{string}")
        public String echo(@PathVariable String string) {
            System.out.println("服务被调用，传入的参数是："+string);
            return "Hello Nacos Discovery\t" + string;
        }
    }
}
