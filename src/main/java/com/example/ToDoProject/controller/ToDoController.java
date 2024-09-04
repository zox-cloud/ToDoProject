package com.example.ToDoProject.controller;


import com.example.ToDoProject.entity.ToDo;
import com.example.ToDoProject.service.ToDoService;
import com.example.ToDoProject.status.ToDoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;


    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return toDoService.createToDo(toDo);
    }

    @GetMapping
    public List<ToDo> getAllToDos(@RequestParam(required = false)ToDoStatus status) {
        return toDoService.getAllToDos(status);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo toDoDetails) {
        return toDoService.update(id , toDoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id) {
        toDoService.delete(id);
    }

}
