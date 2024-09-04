package com.example.ToDoProject.service;


import com.example.ToDoProject.entity.ToDo;
import com.example.ToDoProject.repository.ToDoRepository;
import com.example.ToDoProject.status.ToDoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public List<ToDo> getAllToDos(ToDoStatus status) {
        if(status !=null){
            return toDoRepository.findByStatus(status);
        }
        return toDoRepository.findAll();
    }

    public ToDo update(Long id, ToDo toDoDetails){
        ToDo existingTask = toDoRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Задача с ID" + id + "не найдена"));
        existingTask.setTitle(toDoDetails.getTitle());
        existingTask.setDescription(toDoDetails.getDescription());
        existingTask.setStatus(toDoDetails.getStatus());
        existingTask.setDueTime(toDoDetails.getDueTime());
        return toDoRepository.save(existingTask);
    }

    public void delete(Long id){
        ToDo existingTask = toDoRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Задача  с ID" + id +" не найдена"));
    }

}
