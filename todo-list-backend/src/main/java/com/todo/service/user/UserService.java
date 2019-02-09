package com.todo.service.user;

import com.todo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findUserByUserName(String username);

    User create(User user);
}
