package com.adam.dubbo.web;

import com.adam.dubbo.pojo.User;
import com.adam.dubbo.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    @Reference(check = false,version = "1.0.0",loadbalance = "roundrobin")
    private UserService userService;

    @RequestMapping(value = "/getProviderUserInfo",method = RequestMethod.POST)
    public String getProviderUserInfo() throws InterruptedException {
        for (int i = 100; i > 0; i--) {
            List<User> list = userService.queryAll();
            for (User user : list) {
                System.out.println("=========user.toString():"+user.toString());
            }
            Thread.sleep(1000);
        }
        return "获取服务提供者的user";
    }
}
