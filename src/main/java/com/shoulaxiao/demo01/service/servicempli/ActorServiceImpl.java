package com.shoulaxiao.demo01.service.servicempli;

import com.shoulaxiao.demo01.dao.ActorDao;
import com.shoulaxiao.demo01.entity.Actor;
import com.shoulaxiao.demo01.entity.Movie;
import com.shoulaxiao.demo01.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorDao actorDao;

    @Override
    public List<Actor> getAll() {
        return actorDao.selectAll();
    }

    @Override
    public Actor getActorByName(String actName) {
        if (actName==null){
            System.out.println("actName不能为空");
        }
        return actorDao.selectOne(actName);
    }

    @Override
    public int insertActor(Actor actor) {
        if (actor==null){
            return 0;
        }
        return actorDao.insertActor(actor);
    }
}
