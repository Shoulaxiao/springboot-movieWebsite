package com.shoulaxiao.demo01.dao;

import com.shoulaxiao.demo01.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
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
}
