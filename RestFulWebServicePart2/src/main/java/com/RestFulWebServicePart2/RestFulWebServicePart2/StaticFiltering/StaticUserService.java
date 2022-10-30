package com.RestFulWebServicePart2.RestFulWebServicePart2.StaticFiltering;

import java.util.ArrayList;
import java.util.List;

public class StaticUserService {
    static List<User> users = new ArrayList<User>();

    static{
        users.add(new User(1,20,"vaibhav Kamal","1234"));
        users.add(new User(2,21,"arpit Jain","123456"));
    }

    public User saveUser(User user){
        if(users.add(user)==true)
            return user;
        else
            return null;
    }

    public List<User> returnAllUsers(){
        return users;
    }
}
