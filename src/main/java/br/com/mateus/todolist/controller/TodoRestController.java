package br.com.mateus.todolist.controller;

import br.com.mateus.todolist.entity.Todo;
import br.com.mateus.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoRestController {

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

    // define method GET for find by object Id
    @GetMapping("/todos/{id}")
    public Optional<Todo> findById(@PathVariable int id) {
        return todoService.findById(id);
    }

    // define method PUT for update object
    @PutMapping("/todos")
    public Todo updateTodo(@RequestBody Todo theTodo) {
        return todoService.updateTodo(theTodo);
    }

    // define method DELETE for delete object
    @DeleteMapping("/todos/{id}")
    public String deleteTodo(@PathVariable int id) {
        return todoService.deleteTodo(id);
    }
}
