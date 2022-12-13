package com.example.usersmicroservice.restControllers;

import java.util.List;

import com.example.usersmicroservice.entities.User;
import com.example.usersmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
public class UserRESTController {

    @Autowired
    UserService userService;

    @RequestMapping(path="all", method=RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(method=RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public User addRoleToUser(@RequestBody String[] role){
        return userService.addRoleToUser(role[0], role[1]);
    }



}

