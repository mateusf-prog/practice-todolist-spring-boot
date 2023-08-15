package br.com.mateus.todolist.service;

import br.com.mateus.todolist.dao.TodoDAO;
import br.com.mateus.todolist.entity.Todo;
import br.com.mateus.todolist.exception.EmptyException;
import br.com.mateus.todolist.exception.NullValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoDAO todoDAO;

    // auxiliary method for data validation
    public Todo dataValidation(Todo todo) {
        if (todo.getName() == null || todo.getDescription() == null || todo.getStatus() == null) {
            throw new NullValueException("Name, description or status cannot be null");
        } else {
            return todo;
        }
    }

    // return list with all todos
    public List<Todo> listAll() {
        if (todoDAO.findAll().isEmpty()) {
            throw new EmptyException("List is empty!");
        } else {
            return todoDAO.findAll();
        }
    }
}
