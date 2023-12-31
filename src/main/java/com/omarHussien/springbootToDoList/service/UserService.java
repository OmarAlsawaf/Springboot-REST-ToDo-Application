package com.omarHussien.springbootToDoList.service;

import com.omarHussien.springbootToDoList.model.User;
import com.omarHussien.springbootToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id){
        try{
            return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("To-Do item not found"));
        }catch (IllegalArgumentException e){
            return null;
        }


    }
}
