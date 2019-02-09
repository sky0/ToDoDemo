package com.todo.dao;

import com.todo.entity.Todo;
import com.todo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoDao extends CrudRepository<Todo, Integer> {

    List<Todo> findAllByUser(User user);
}
