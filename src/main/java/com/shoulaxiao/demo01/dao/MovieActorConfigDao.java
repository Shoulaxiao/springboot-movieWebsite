package com.shoulaxiao.demo01.dao;

import com.shoulaxiao.demo01.entity.MovieActorConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Component("movieActorConfigDao")

@Repository
public interface MovieActorConfigDao {

    /**
     * 查询所有的关联表
     * @return
     */
    List<MovieActorConfig> selectMovieActorConfig();


    /**
     * 根据电影查询
     * @param movieId 电影movieId
     * @return
     */
    List<MovieActorConfig> selectMovieActorConfigByMovie(int movieId);

    /**
     * 根据演员查询
     * @param actorId 演员Id
     * @return
     */
    List<MovieActorConfig> selectMovieActorConfigByeActor(int actorId);
}
