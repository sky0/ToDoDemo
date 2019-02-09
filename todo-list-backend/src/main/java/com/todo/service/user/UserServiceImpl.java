package com.todo.service.user;

import com.todo.dao.UserDao;
import com.todo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User findUserByUserName(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    @Transactional
    public User create(User user) {
        return userDao.save(user);
    }

   
}
