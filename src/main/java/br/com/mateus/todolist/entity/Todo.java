package br.com.mateus.todolist.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private int id;

    @Column(name = "todo_name")
    private String name;

    @Column(name = "todo_description")
    private String description;

    @Column(name = "todo_status")
    private String status;
}
