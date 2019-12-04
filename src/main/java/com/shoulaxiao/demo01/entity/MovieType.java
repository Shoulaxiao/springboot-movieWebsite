package com.shoulaxiao.demo01.entity;

import java.io.Serializable;

public class MovieType implements Serializable {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MovieType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
