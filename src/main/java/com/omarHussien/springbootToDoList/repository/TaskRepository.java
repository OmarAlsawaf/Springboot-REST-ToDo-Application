package com.omarHussien.springbootToDoList.repository;

import com.omarHussien.springbootToDoList.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long> {
}
