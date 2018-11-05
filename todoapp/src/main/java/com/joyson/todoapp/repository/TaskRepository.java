package com.joyson.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joyson.todoapp.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
