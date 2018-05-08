package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author liqiang
 * @date 2018/5/8
 */
@Service
public class HiService {

    @Autowired
    private RestTemplate restTemp;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name) {
        return restTemp.getForObject("http://EUREKA-CLIENT/hi?name="+name, String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
