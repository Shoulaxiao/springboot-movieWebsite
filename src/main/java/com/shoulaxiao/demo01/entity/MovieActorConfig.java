package com.shoulaxiao.demo01.entity;

import java.io.Serializable;

public class MovieActorConfig implements Serializable {

    private int id;
    private int movieId;
    private int actorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Override
    public String toString() {
        return "MovieActorConfig{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", actorId=" + actorId +
                '}';
    }
}
