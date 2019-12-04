package com.shoulaxiao.demo01.service;

import com.shoulaxiao.demo01.entity.Movie;

import java.util.List;

public interface MovieService {

    /**
     * 根据页数进行查询
     * @return
     */
    List<Movie> findList();
}
