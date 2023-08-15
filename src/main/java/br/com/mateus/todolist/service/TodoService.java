package br.com.mateus.todolist.service;

import br.com.mateus.todolist.dao.TodoDAO;
import br.com.mateus.todolist.entity.Todo;
import br.com.mateus.todolist.exception.EmptyException;
import br.com.mateus.todolist.exception.NotFoundException;
import br.com.mateus.todolist.exception.NullValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    // method for create and return a ToDo
    @Transactional
    public Todo createTodo(Todo obj) {

        if (dataValidation(obj)) {
            todoDAO.save(obj);
            return obj;
        } else {
            throw new NullValueException("Name, description or status cannot be null!");
        }
    }

    // method for find by id
    public Optional<Todo> findById(int id) {
        Optional<Todo> theTodo = todoDAO.findById(id);

        if (theTodo.isPresent()) {
            return theTodo;
        } else {
            throw new NotFoundException("Object not found!");
        }
    }
}
