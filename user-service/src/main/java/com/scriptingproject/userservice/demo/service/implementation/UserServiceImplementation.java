package com.scriptingproject.userservice.demo.service.implementation;

import com.scriptingproject.userservice.demo.domain.User;
import com.scriptingproject.userservice.demo.domain.UserRepository;
import com.scriptingproject.userservice.demo.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {


    private UserRepository userRepository;
    @Autowired
    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public UserServiceImplementation(){

    }

    @Override
    public void save(User user) {
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        Iterable<User> users=userRepository.findAll();
        return Lists.newArrayList(users);
    }
}
