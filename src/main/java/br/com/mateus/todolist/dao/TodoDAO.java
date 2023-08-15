package br.com.mateus.todolist.dao;

import br.com.mateus.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDAO extends JpaRepository<Todo, Integer> {
}
