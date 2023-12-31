package com.omarHussien.springbootToDoList.service;

import com.omarHussien.springbootToDoList.model.Task;
import com.omarHussien.springbootToDoList.model.User;
import com.omarHussien.springbootToDoList.repository.TaskRepository;
import com.omarHussien.springbootToDoList.repository.UserRepository;
import com.omarHussien.springbootToDoList.requests.TaskRequest;
import com.omarHussien.springbootToDoList.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    public List<User> getAllUsers(){
        List<User> usersList = new ArrayList<>();
        for (User user : userRepository.findAll()){
            usersList.add(user);
        }
        return usersList;
    }

    public User getUserById(Long id){
        try{
            return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("To-Do item not found"));
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    public User addUser(UserRequest request){
        return userRepository.save(new User(request.getUsername(),request.getPassword()));
    }

    public void deleteUser(long id){
        userRepository.delete(userRepository.findById(id).orElseThrow(()->new NoSuchElementException()));
    }

    public void addTask(long userId , TaskRequest request){
        User user = userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        Task task = new Task(request.getTitle(), request.getDescription());
        user.getTaskList().add(task);
        taskRepository.save(task);
        userRepository.save(user);

    }

    public void markTaskAsComplete(long taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new NoSuchElementException());
        task.setIsCompleted(Boolean.TRUE);
        taskRepository.save(task);
    }

    public void deleteTask(long taskId,long userId){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new NoSuchElementException());
        User user = userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        user.getTaskList().remove(task);
        taskRepository.delete(task);
    }

}
