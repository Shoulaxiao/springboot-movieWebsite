package com.shoulaxiao.demo01.dao;

import com.shoulaxiao.demo01.entity.Actor;
import com.shoulaxiao.demo01.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDao {

    /**
     * 查询所有
     * @return
     */
    List<Actor> selectAll();

    /**
     * 通过演员名称查询
     * @param actName
     * @return
     */
    Actor selectOne(@Param("actName") String actName);

    /**
     * 插入actor的信息
     * @param actor
     * @return
     */
    int insertActor(Actor actor);

}
