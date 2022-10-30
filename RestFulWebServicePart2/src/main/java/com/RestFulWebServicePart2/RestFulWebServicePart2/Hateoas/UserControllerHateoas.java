package com.RestFulWebServicePart2.RestFulWebServicePart2.Hateoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserControllerHateoas {
    @Autowired
    private UserServiceHateoas userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/hateusers/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        Optional<User> user = userService.getUser(id);

        EntityModel<User> resource = EntityModel.of(user.get());

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }
}
