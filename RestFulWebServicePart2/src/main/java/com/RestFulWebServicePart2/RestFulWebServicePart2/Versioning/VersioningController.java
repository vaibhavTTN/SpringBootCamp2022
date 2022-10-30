package com.RestFulWebServicePart2.RestFulWebServicePart2.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    String userV1 = new UserV1(1,20,"vaibhav kamal").toString();
    String userV2 = new UserV2(1,20,2000,"vaibhav kamal","Software Engineer","kanpur").toString();


    @RequestMapping(path = "/user/v1")
    public String getUserDetails(){
        return userV1;
    }

    @RequestMapping(path = "/user/v2")
    public String getEnhancedUserDetails(){
        return userV2;
    }

    @GetMapping(value = "/user/param",params = "version=1")
    public String getUserDetailsParam(){
        return userV1;
    }

    @GetMapping(value = "/user/param",params = "version=2")
    public String getEnhancedUserDetailsParam(){
        return userV2;
    }


    @GetMapping(value = "/user/header",headers = "X-API-VERSION=1")
    public String getUserDetailsHeader(){
        return userV1;
    }

    @GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
    public String getEnhancedUserDetailsHeader(){
        return userV2;
    }

    @GetMapping(value = "/user/produces", produces = "application/vnd.company.app-v1+json" )
    public String getUserDetailsMedia(){
        return userV1;
    }

    @GetMapping(value = "/user/produces", produces = "application/vnd.company.app-v2+json")
    public String getEnhancedUserDetailsMedia(){
        return userV2;
    }
}
