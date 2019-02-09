package com.todo.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.todo.utils.jackson.View;

import javax.persistence.*;


@Entity
@Table(name="todo_list")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @JsonView(View.Public.class)
    private int id;

    @JsonView(View.Public.class)
    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonView(View.Public.class)
    @Column(name="is_completed")
    private Boolean isCompleted = Boolean.FALSE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCompleted() {
        return done;
    }

    public void setIsCompleted(boolean done) {
        this.done = done;
    }
}
