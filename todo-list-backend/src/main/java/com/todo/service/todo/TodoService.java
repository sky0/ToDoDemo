package com.todo.service.todo;

import com.todo.entity.Todo;

import java.util.List;


public interface TodoService {
    List<Todo> findAll();

    Todo findById(Integer id);

    Todo create(Todo todo);

    Todo update(Todo todo,User user);

    void delete(Integer id);
}
