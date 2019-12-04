package com.shoulaxiao.demo01.controller;


import com.shoulaxiao.demo01.dao.MovieDao;
import com.shoulaxiao.demo01.entity.Movie;
import com.shoulaxiao.demo01.service.MovieService;
import com.shoulaxiao.demo01.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/query")
    @ResponseBody
    public Message query(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        if (pn<0){
            pn=1;
        }
        List<Movie> movieList=movieService.findList();
        return Message.success().add("movie",movieList);
    }
}
