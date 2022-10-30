package com.RestFulWebServicePart2.RestFulWebServicePart2.ContentNegotiationAndSwagger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    static List<User> users = new ArrayList<User>();
    static{
        users.add(new User(1,"vaibhav",20));
        users.add(new User(2,"kartikey",21));
    }

    public String  saveUser(User user){
        return users.add(user)?user.toString():null;
    }

    public List getUsers(){
        return users;
    }

    public boolean deleteUser(int id){
        return users.removeIf(user->user.getId()==id);
    }
}
