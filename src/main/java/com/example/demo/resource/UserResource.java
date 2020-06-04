package com.example.demo.resource;

import com.example.demo.model.User;
import com.example.demo.repository.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/user")
public class UserResource {

    @Autowired
    UserReposiroty userReposiroty;

    @GetMapping(value = "/all")
    public List<User> getAll() {
        return userReposiroty.findAll();
    }

    @GetMapping(value = "/by-id")
    public User getUserById(@RequestBody final Integer id) {
        return userReposiroty.getOne(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody final User user) {
        userReposiroty.save(user);
        return;
    }
}
