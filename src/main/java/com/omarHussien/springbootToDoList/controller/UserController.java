package com.omarHussien.springbootToDoList.controller;

import com.omarHussien.springbootToDoList.model.User;
import com.omarHussien.springbootToDoList.repository.TaskRepository;
import com.omarHussien.springbootToDoList.repository.UserRepository;
import com.omarHussien.springbootToDoList.requests.TaskRequest;
import com.omarHussien.springbootToDoList.requests.UserRequest;
import com.omarHussien.springbootToDoList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private TaskRepository taskRepository;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        if(userService.getUserById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserRequest request){
        User newUser = userService.addUser(request);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<Object> addTaskToUser(@PathVariable long id , @RequestBody TaskRequest request){
        userService.addTask(id,request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> markTaskAsComplete(@PathVariable long id){
        userService.markTaskAsComplete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{userId}/tasks/{taskId}")
    public ResponseEntity<Object> deleteTask(@PathVariable long userId ,@PathVariable long taskId){
        userService.deleteTask(taskId,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
