package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/user")
    public User addAndGet(User user) throws SQLException {
        userDao.add(user);
        return userDao.findById("1");
    }


    @DeleteMapping("/user/user")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}
