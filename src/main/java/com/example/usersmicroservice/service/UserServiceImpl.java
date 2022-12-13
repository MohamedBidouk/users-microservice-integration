package com.example.usersmicroservice.service;

import com.example.usersmicroservice.entities.Role;
import com.example.usersmicroservice.entities.User;
import com.example.usersmicroservice.repos.RoleRepository;
import com.example.usersmicroservice.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User usr = userRepository.findByUsername(username);
        Role role = roleRepository.findByRole(rolename);

        usr.getRoles().add(role);

        //userRepository.save(usr); transactional will do that

        return usr;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}

