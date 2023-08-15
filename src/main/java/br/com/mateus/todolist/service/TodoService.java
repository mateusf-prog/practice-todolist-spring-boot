package br.com.mateus.todolist.service;

import br.com.mateus.todolist.dao.TodoDAO;
import br.com.mateus.todolist.entity.Todo;
import br.com.mateus.todolist.exception.EmptyException;
import br.com.mateus.todolist.exception.NullValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoDAO todoDAO;

    // auxiliary method for data validation
    public boolean dataValidation(Todo todo) {
        if (todo.getName() == null || todo.getDescription() == null || todo.getStatus() == null) {
            return false;
        } else {
            return true;
        }
    }

    // return list with all todos
    public List<Todo> listAll() {

        if (todoDAO.findAll().isEmpty()) {
            throw new EmptyException("List is empty!");
        }

        return todoDAO.findAll();
    }

    // create and return a ToDo
    @Transactional
    public Todo createTodo(Todo obj) {

        if (dataValidation(obj)) {
            todoDAO.save(obj);
            return obj;
        } else {
            throw new NullValueException("Name, description or status cannot be null!");
        }
    }
}
