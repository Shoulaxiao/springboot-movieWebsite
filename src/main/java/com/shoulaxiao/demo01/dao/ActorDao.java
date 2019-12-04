package com.shoulaxiao.demo01.dao;

import com.shoulaxiao.demo01.entity.Actor;
import com.shoulaxiao.demo01.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDao {

    /**
     * 查询所有
     * @return
     */
    List<Actor> selectAll();

}
