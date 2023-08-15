package br.com.mateus.todolist.controller;

import br.com.mateus.todolist.entity.Todo;
import br.com.mateus.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // define method GET for list all
    @GetMapping("/todos")
    public List<Todo> listAll() {
        return todoService.listAll();
    }

    // define method POST for save object
    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo obj) {
        return todoService.createTodo(obj);
    }
}
