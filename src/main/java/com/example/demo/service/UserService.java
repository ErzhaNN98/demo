package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserReposiroty userReposiroty;

    public UserService(UserReposiroty userReposiroty) {
        this.userReposiroty = userReposiroty;
    }

    public void createUser(User user) {
        userReposiroty.save(user);
    }

    public List<User> findAll() {
        return userReposiroty.findAll();
    }

    public User findById(Integer id) {
        return userReposiroty.findById(id).orElse(null);
    }

    public User findByLogin(String login) {
        return userReposiroty.findByLogin(login);
    }
}
