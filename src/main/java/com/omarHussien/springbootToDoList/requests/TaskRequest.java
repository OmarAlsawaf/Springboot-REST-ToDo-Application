package com.omarHussien.springbootToDoList.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskRequest {

    private String title;
    private String description;


}
