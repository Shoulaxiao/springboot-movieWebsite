package com.shoulaxiao.demo01.service;


import com.shoulaxiao.demo01.entity.MovieActorConfig;

import java.util.List;

public interface MovieActorConfigService {

    /**
     * 得到所有的演员-电影关联表
     * @return
     */
    List<MovieActorConfig> getAll();

    /**
     * 得到所有的演员-电影关联表，通过电影的id
     * @param movieId
     * @return
     */
    List<MovieActorConfig> getByMovie(int movieId);

    /**
     * 得到所有的演员-电影关联表，通过演员的id
     * @param actorId
     * @return
     */
    List<MovieActorConfig> getByActor(int actorId);
}
