package com.vit.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vit.todoapp.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
