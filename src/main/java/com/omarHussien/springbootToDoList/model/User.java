package com.omarHussien.springbootToDoList.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "myUsers")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> taskList = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
