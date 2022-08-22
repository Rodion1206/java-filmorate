package ru.yandex.practicum.filmorate.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exceptions.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private Map<Integer, User> users = new HashMap<>();
    private static int userId = 0;

    private int getUserId(){
        return ++userId;
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user) {
        log.info("request for add user");
        if (user.getId() == null) {
            user.setId(getUserId());
        }
        if (user.getName().isEmpty()) {
            user.setName(user.getLogin());
        }
        users.put(user.getId(), user);
        return user;
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) {
        log.info("request for update user");
        if (users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            return user;
        }
        throw new ValidationException(HttpStatus.NOT_FOUND, "user not found");
    }

    @GetMapping
    public List<User> getAllUsers() {
        log.info("request for all users");
        List<User> result = new ArrayList<>();
        for (User u : users.values()) {
            result.add(u);
        }
        return result;
    }
    
}
