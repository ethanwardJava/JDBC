package com.arcade;

public class Task {
    private Long id;
    private String name;

    public Task() {
    }

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
