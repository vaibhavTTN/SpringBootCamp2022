package com.RestFulWebServicePart2.RestFulWebServicePart2.StaticFiltering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaticUserController {
    StaticUserService userService = new StaticUserService();

    @RequestMapping("/staticFiltering")
    public User saveUser(){
        return new User(1,20,"vaibhav","1234");
    }

    @GetMapping("/staticReturnAllUsers")
    public List<User> returnAllUsers(){
        return userService.returnAllUsers();
    }
}
