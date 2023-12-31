package com.omarHussien.springbootToDoList.config;

import com.omarHussien.springbootToDoList.model.Task;
import com.omarHussien.springbootToDoList.model.User;
import com.omarHussien.springbootToDoList.repository.TaskRepository;
import com.omarHussien.springbootToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedDataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;
    @Override
    public void run(String... args) throws Exception {

        if(userRepository.count()==0 && taskRepository.count()==0){
            Task task1 = new Task();
            task1.setTitle("clean the room");
            task1.setDescription("do the bed and swipe the floor");
            User user = new User();
            user.setUsername("Adams");
            user.setPassword("HJI548OET*(&*(&^&");
            user.getTaskList().add(task1);
            userRepository.save(user);
            taskRepository.save(task1);


            Task task2 = new Task();
            task2.setTitle("Buy Groceries");
            task2.setDescription("buy milk and eggs");
            Task task3 = new Task();
            task3.setTitle("wash the car");
            task3.setDescription("take the car to the car wash");
            User user2 = new User();
            user2.setUsername("Jessica");
            user2.setPassword("JTHW&^#JT)YJIOA&");
            user2.getTaskList().add(task2);
            user2.getTaskList().add(task3);
            userRepository.save(user2);
            taskRepository.save(task2);
            taskRepository.save(task3);


        }

    }
}
