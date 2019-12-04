package com.shoulaxiao.demo01.service;


import com.shoulaxiao.demo01.entity.MovieActorConfig;

import java.util.List;

public interface MovieActorConfigService {

    List<MovieActorConfig> getAll();

    List<MovieActorConfig> getByMovie(int movieId);

    List<MovieActorConfig> getByActor(int actorId);
}
