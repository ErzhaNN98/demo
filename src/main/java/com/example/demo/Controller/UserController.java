package com.example.demo.Controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private Integer startIte;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String create(@RequestBody User user) throws Exception {
        validate(user);
        try {
            userService.createUser(user);
            return user.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody String params) {
        startIte = 14;
        String login = getUsername(params);
        String password = getPassword(params);
        User user = userService.findByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            return "1";
        }
        return user.toString();
    }

    @GetMapping("/check")
    public List<User> get() {
        return userService.findAll();
    }

    private void validate(User user) throws Exception {
        User user1 = userService.findByLogin(user.getLogin());
        if (user1 != null) {
            throw new Exception("User with this login exist");
        }
    }

    private String getUsername(String params) {
        StringBuilder res = new StringBuilder();
        for (int i = startIte;;i++) {
            if (params.charAt(i) == '"') {
                startIte = i + 15;
                break;
            }
            res.append(params.charAt(i));
        }
        return res.toString();
    }

    private String getPassword(String params) {
        StringBuilder res = new StringBuilder();
        for (int i = startIte;; i++) {
            if (params.charAt(i) == '"') {
                break;
            }
            res.append(params.charAt(i));
        }
        return res.toString();
    }

}
