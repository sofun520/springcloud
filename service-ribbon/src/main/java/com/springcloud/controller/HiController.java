package com.springcloud.controller;

import com.springcloud.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiang
 * @date 2018/5/8
 */
@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return hiService.hi(name);
    }

}
