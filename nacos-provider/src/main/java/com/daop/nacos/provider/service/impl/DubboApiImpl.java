package com.daop.nacos.provider.service.impl;

import com.daop.dubbo.api.DubboEchoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @BelongsProject: spring-cloud-nacos
 * @BelongsPackage: com.daop.nacos.provider.service.impl
 * @Description: 通过Dubbo对服务进行注册
 * @DATE: 2020-09-28
 * @AUTHOR: Administrator
 **/
@DubboService
public class DubboApiImpl implements DubboEchoService {
    @Override
    public String echoService(String message) {
        return "[ECHO]"+message;
    }
}
