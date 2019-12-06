package com.shoulaxiao.demo01.controller;

import com.shoulaxiao.demo01.entity.Actor;
import com.shoulaxiao.demo01.service.ActorService;
import com.shoulaxiao.demo01.util.MessageUtil;
import com.shoulaxiao.demo01.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: guozhonghao
 * Date: 2019/12/6
 * Time: 18:28
 * Description: No Description
 */

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;


    /**
     * 查找相关演员的信息
     * @param actorName
     * @return
     */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public MessageUtil queryActorBase(@RequestParam(value = "actorName")String actorName){
        if (StringUtil.boolIsEmpty(actorName)){
            return MessageUtil.fail("查找的姓名不能为空");
        }

        Actor actor=actorService.getActorByName(actorName);
        if (actor==null){
            return MessageUtil.fail("未查询到相应的演员信息");
        }
        return MessageUtil.success().add("actor",actor);
    }


    /**
     * 插入演员的相关信息
     * @param actor
     * @return
     */
    @RequestMapping("/insert")
    public MessageUtil insertActor(Actor actor){
        if (actor==null){
            return MessageUtil.fail();
        }
        int flag=actorService.insertActor(actor);
        if (flag>0){
            return MessageUtil.success();
        }
        return MessageUtil.fail();
    }
}
