package com.example.ToDoProject.repository;

import com.example.ToDoProject.entity.ToDo;
import com.example.ToDoProject.status.ToDoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByStatus(ToDoStatus status);
}
