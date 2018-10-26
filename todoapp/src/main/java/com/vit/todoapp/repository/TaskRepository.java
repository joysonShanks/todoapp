package com.vit.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vit.todoapp.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
