package com.RestFulWebServicePart1.RestFulWebServicePart1.Controllers;

import com.RestFulWebServicePart1.RestFulWebServicePart1.Models.Great;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreatResource {

    @GetMapping("/")
    public Great great(){
        return new Great("Welcome to spring boot");
    }

}
