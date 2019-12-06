package com.shoulaxiao.demo01.entity;

/**
 * Created with IntelliJ IDEA.
 * User: guozhonghao
 * Date: 2019/12/6
 * Time: 15:42
 * Description: No Description
 */
public class Director {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
}
