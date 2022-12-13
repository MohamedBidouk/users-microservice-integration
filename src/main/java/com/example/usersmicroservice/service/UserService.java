package com.example.usersmicroservice.service;

import com.example.usersmicroservice.entities.User;
import com.example.usersmicroservice.entities.Role;

import java.util.List;
public interface UserService {
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> findAllUsers();
}

