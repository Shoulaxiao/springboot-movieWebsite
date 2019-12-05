package com.shoulaxiao.demo01.service.serviceImpl;


import com.shoulaxiao.demo01.dao.MovieDao;
import com.shoulaxiao.demo01.entity.Movie;
import com.shoulaxiao.demo01.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> findList( ) {
        return movieDao.selectAllMovie();
    }

    @Override
    public List<Movie> insertMovies(List<Movie> list) {
        return movieDao.selectAllMovie();
    }

    @Override
    public int insertMovie(Movie movie) {
        return movieDao.insertSingle(movie);
    }
}
