package com.todo.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.todo.entity.User;
import com.todo.utils.TokenService;
import com.todo.utils.jackson.View;
import com.todo.utils.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import com.todo.utils.View;

import static com.todo.utils.Constants.X_TOKEN;

@RestController
@RequestMapping("/api/user")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @JsonView(View.Public.class)
    public User login(User user) {
        User newUser=userService.findUserByUserName(user.getUsername());
        if(user==null){
            return userService.create(user);
        }
        else{
            if(BCrypt.checkpw(user.getPassword(), newUser.getPassword())){
                return newUser;
            }
            else{
                return throws new Exception("Password is not matched");
            }
        }

    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException {

        Optional<String> token = Optional.ofNullable(httpRequest.getHeader(X_TOKEN));
        tokenService.clear(token.get());

        httpRequest.logout();
    }

   
}
