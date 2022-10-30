package com.RestFulWebServicePart2.RestFulWebServicePart2.ContentNegotiationAndSwagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    UserService userService = new UserService();

    @ApiOperation(
            value="Save User Information",
            notes = "Saves user information in the list with help of @RequestBody"
    )
    @PostMapping(
            path = "/api/save-user-info",
            consumes = MediaType.APPLICATION_XML_VALUE
    )
    public String UserInformation(@RequestBody User user){
        return userService.saveUser(user);
    }


    @ApiOperation(
            value="Retrieve all users",
            notes = "Retrieves all users stored in the list"
    )
    @GetMapping(
            path="/api/getUsers",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @ApiOperation(
            value="Delete user",
            notes = "Deletes a user from the list whose id is passed in url"
    )
    @DeleteMapping(path="/api/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        if(userService.deleteUser(id)) {
            return "User with id :" + id + " got deleted";
        }else{
            return "User wasn't deleted";
        }
    }

}
