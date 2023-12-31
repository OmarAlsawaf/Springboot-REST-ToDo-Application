package com.omarHussien.springbootToDoList.config;

import com.omarHussien.springbootToDoList.model.Task;
import com.omarHussien.springbootToDoList.model.User;
import com.omarHussien.springbootToDoList.repository.TaskRepository;
import com.omarHussien.springbootToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class SeedDataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;
    @Override
    public void run(String... args) throws Exception {
        Task task1 = new Task();
        task1.setTitle("task 1");
        task1.setDescription("task 1 details");
        User user = new User();
        user.setUsername("user1");
        user.setPassword("hash");
        user.getTaskList().add(task1);
        taskRepository.save(task1);
        userRepository.save(user);
    }
}
