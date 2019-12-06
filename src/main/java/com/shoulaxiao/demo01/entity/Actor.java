package com.shoulaxiao.demo01.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class Actor implements Serializable {

    private int actId;
    private String actName;
    private int actAge;

    //演员的作品
    private List<Movie> movies;

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public int getActAge() {
        return actAge;
    }

    public void setActAge(int actAge) {
        this.actAge = actAge;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actId=" + actId +
                ", actName='" + actName + '\'' +
                ", actAge=" + actAge +
                ", movies=" + movies +
                '}';
    }
}
