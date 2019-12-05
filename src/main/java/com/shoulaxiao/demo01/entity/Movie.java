package com.shoulaxiao.demo01.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

public class Movie implements Serializable {

    private int movieId;
    private String movieName;
    private Date date;
    private String movieDes;
//    private List<MovieType> type;
    private List<Actor> actors;

    private String downloadUrl;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public List<MovieType> getType() {
//        return type;
//    }
//
//    public void setType(List<MovieType> type) {
//        this.type = type;
//    }

    public List<Actor> getActor() {
        return actors;
    }

    public void setActor(List<Actor> actor) {
        this.actors = actor;
    }

    public String getMovieDes() {
        return movieDes;
    }

    public void setMovieDes(String movieDes) {
        this.movieDes = movieDes;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", date=" + date +
                ", movieDes='" + movieDes + '\'' +
                ", actors=" + actors +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}
