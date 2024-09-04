package com.example.ToDoProject.entity;


import com.example.ToDoProject.status.ToDoStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "todo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private ToDoStatus status = ToDoStatus.NOT_COMPLETED;

    private LocalDate createDate = LocalDate.now();

    private LocalDate dueTime;

    public ToDo() {
    }

    public ToDo(Long id, String title, String description, ToDoStatus status, LocalDate createDate, LocalDate dueTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.dueTime = dueTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ToDoStatus getStatus() {
        return status;
    }

    public void setStatus(ToDoStatus status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueTime() {
        return dueTime;
    }

    public void setDueTime(LocalDate dueTime) {
        this.dueTime = dueTime;
    }
}
