package com.shoulaxiao.demo01.dao;

import com.shoulaxiao.demo01.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao {

    /**
     * 查询所有的电影
     * @return
     */
    List<Movie> selectAllMovie();


    /**
     * 根据电影名字查询
     * @param movieName
     * @return 返回查询的电影
     */
    Movie selectByMovieByName(@Param("movieName") String movieName);

    /**
     * 批量插入
     * @param movieList
     * @return 一个整数
     */
    int insertByList(@Param("movieList") List<Movie> movieList);

    /**
     * 单个插入
     * @param movie
     * @return 插入成功，返回一个证书
     */
    int insertSingle(Movie movie);
}
