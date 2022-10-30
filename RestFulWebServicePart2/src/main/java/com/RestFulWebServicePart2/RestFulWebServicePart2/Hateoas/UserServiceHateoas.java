package com.RestFulWebServicePart2.RestFulWebServicePart2.Hateoas;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceHateoas {
    static List<User> users = new ArrayList<User>();

    static{
        users.add(new User(1,20,"kartikey"));
        users.add(new User(2,22,"Vaibhav"));
    }

    public List<User> getAllUsers(){
        return users;
    }

    public Optional<User> getUser(int id){
        return users.stream().filter(u->u.getId()==id).findFirst();
    }
}
