package com.shoulaxiao.demo01.service.serviceImpl;

import com.shoulaxiao.demo01.dao.MovieActorConfigDao;
import com.shoulaxiao.demo01.entity.MovieActorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieActorConfigServiceImpl implements com.shoulaxiao.demo01.service.MovieActorConfigService {

    @Autowired
    private MovieActorConfigDao movieActorConfigDao;

    @Override
    public List<MovieActorConfig> getAll() {
        return movieActorConfigDao.selectMovieActorConfig();
    }

    @Override
    public List<MovieActorConfig> getByMovie(int movieId) {
        if (movieId<0){
            return null;
        }
        return movieActorConfigDao.selectMovieActorConfigByMovie(movieId);
    }

    @Override
    public List<MovieActorConfig> getByActor(int actorId) {
        if (actorId<0){
            return null;
        }
        return movieActorConfigDao.selectMovieActorConfigByeActor(actorId);
    }
}
