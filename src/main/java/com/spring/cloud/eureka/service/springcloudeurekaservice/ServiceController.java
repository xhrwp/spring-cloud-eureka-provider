package com.spring.cloud.eureka.service.springcloudeurekaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author 许洪荣
 * @date 2017/8/15
 */
@RestController
@RequestMapping(value = "/eureka")
public class ServiceController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/testAdd/{id}" ,method = RequestMethod.GET)
    public Integer add(@PathVariable int id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = id + id;
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

    @RequestMapping(value = "/testStr" ,method = RequestMethod.GET)
    public String testStr(@RequestParam String userName,@RequestParam String address) {
        ServiceInstance instance = client.getLocalServiceInstance();
        String r = userName + "==" + address;
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

    @PostMapping(value = "/addUser")
    public UserInfo addUser(@RequestBody UserInfo userInfo) {
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + userInfo.toString());
        return userInfo;
    }

}
