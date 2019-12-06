package com.shoulaxiao.demo01.service;

import com.shoulaxiao.demo01.entity.Movie;

import java.util.List;

public interface MovieService {

    /**
     * 根据页数进行查询
     * @return list
     */
    List<Movie> findList();

    /**
     * 根据电影名字进行查询
     * @param movieName
     * @return 电影
     */
    Movie findByMovieByName(String movieName);

    /**
     * 批量插入
     * @param list
     * @return
     */
    List<Movie> insertMovies(List<Movie> list);

    /**
     * 插入一个电影
     * @param movie 电影bean
     * @return 成功返回大于0的整数
     */
    int insertMovie(Movie movie);
}
