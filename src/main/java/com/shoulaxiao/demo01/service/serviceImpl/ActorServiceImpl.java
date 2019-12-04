package com.shoulaxiao.demo01.service.serviceImpl;

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
}
