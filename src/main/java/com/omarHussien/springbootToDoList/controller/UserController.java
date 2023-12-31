package com.omarHussien.springbootToDoList.controller;

import com.omarHussien.springbootToDoList.model.User;
import com.omarHussien.springbootToDoList.repository.TaskRepository;
import com.omarHussien.springbootToDoList.repository.UserRepository;
import com.omarHussien.springbootToDoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        if(userService.getUserById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
