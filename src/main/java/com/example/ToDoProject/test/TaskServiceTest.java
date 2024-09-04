package com.example.ToDoProject.test;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.ToDoProject.entity.ToDo;
import com.example.ToDoProject.service.ToDoService;
import com.example.ToDoProject.status.ToDoStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class TaskServiceTest {

    @Autowired
    private ToDoService toDoService;

    @Test
    public void testCreateTask(){
        ToDo toDo = new ToDo();
        toDo.setTitle("ToDo Title");
        toDo.setDescription("ToDo Description");

        ToDo createTodo = toDoService.createToDo(toDo);

        assertThat(createTodo.getId()).isNotNull();
        assertThat(createTodo.getStatus()).isEqualTo(ToDoStatus.NOT_COMPLETED);
        assertThat(createTodo.getTitle()).isEqualTo("ToDo Title");
        assertThat(createTodo.getDescription()).isEqualTo("ToDo Description");

    }
}
