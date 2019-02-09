package com.todo.dao;

import com.todo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    User findUserByUsername(String username);
}
