package com.shoulaxiao.demo01.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

public class Movie implements Serializable {

    private int movieId;//id
    private String movieName;//片名
    private String years;//年代
    private String placeOrigin;//产地
    private String category;//类别
    private String language;//语言
    private String releaseDate;//上映日期
    private String imdbSocre;//imdb得分
    private String beanSocre;//豆瓣得分
    private String fileFormat;//文件格式
    private String vedioSzie;//视频尺寸
    private String sheelLenth;//片长
    private String imgUrl;//海报地址
    private List<Director> directors;//导演
    private List<Actor> actors;//主演
    private String briefIntoduction;//简介

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", years='" + years + '\'' +
                ", placeOrigin='" + placeOrigin + '\'' +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", imdbSocre='" + imdbSocre + '\'' +
                ", beanSocre='" + beanSocre + '\'' +
                ", fileFormat='" + fileFormat + '\'' +
                ", vedioSzie='" + vedioSzie + '\'' +
                ", sheelLenth='" + sheelLenth + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", directors=" + directors +
                ", actors=" + actors +
                ", briefIntoduction='" + briefIntoduction + '\'' +
                '}';
    }

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

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImdbSocre() {
        return imdbSocre;
    }

    public void setImdbSocre(String imdbSocre) {
        this.imdbSocre = imdbSocre;
    }

    public String getBeanSocre() {
        return beanSocre;
    }

    public void setBeanSocre(String beanSocre) {
        this.beanSocre = beanSocre;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getVedioSzie() {
        return vedioSzie;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public void setVedioSzie(String vedioSzie) {
        this.vedioSzie = vedioSzie;
    }

    public String getSheelLenth() {
        return sheelLenth;
    }

    public void setSheelLenth(String sheelLenth) {
        this.sheelLenth = sheelLenth;
    }


    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getBriefIntoduction() {
        return briefIntoduction;
    }

    public void setBriefIntoduction(String briefIntoduction) {
        this.briefIntoduction = briefIntoduction;
    }
}
