package com.scriptingproject.userservice.demo.service;

import com.scriptingproject.userservice.demo.domain.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> getUser();
}
