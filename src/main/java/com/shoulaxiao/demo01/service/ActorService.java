package com.shoulaxiao.demo01.service;

import com.shoulaxiao.demo01.entity.Actor;
import com.shoulaxiao.demo01.entity.Movie;

import java.util.List;

public interface ActorService {


    /**
     * 得到所有的演员列表
     * @return 返回List
     */
    List<Actor> getAll();

    Actor getActorByName(String actName);

    /**
     * 单个插入
     * @param actor
     * @return
     */
    int insertActor(Actor actor);
}
