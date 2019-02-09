package com.todo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.todo.entity.Todo;
import com.todo.service.todo.TodoService;
import com.todo.utils.Constants;
import com.todo.utils.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @JsonView(View.Public.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getAll() {
        return todoService.findAll();
    }

    @JsonView(View.Public.class)
    @RequestMapping(value = "/{"+ Constants.TODO_ID_PARAM +"}", method = RequestMethod.GET)
    public Todo getById(@PathVariable(value = Constants.TODO_ID_PARAM) Integer id) {
        return todoService.findById(id);
    }

    @JsonView(View.Public.class)
    @RequestMapping(method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @JsonView(View.Public.class)
    @RequestMapping(value = "/{"+ Constants.TODO_ID_PARAM +"}", method = RequestMethod.PUT)
    public Todo update(@RequestBody Todo todo,@RequestBody User user) {
        return todoService.update(todo,user);
    }

    @RequestMapping(value = "/{"+ Constants.TODO_ID_PARAM +"}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = Constants.TODO_ID_PARAM) Integer id) {
        todoService.delete(id);
    }
}
