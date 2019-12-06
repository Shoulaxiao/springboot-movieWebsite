package com.shoulaxiao.demo01.controller;


import com.shoulaxiao.demo01.common.movieSpider.spider01.SpiderMovieDetail;
import com.shoulaxiao.demo01.common.movieSpider.spider01.SpiderMovieList;
import com.shoulaxiao.demo01.entity.Movie;
import com.shoulaxiao.demo01.service.MovieService;
import com.shoulaxiao.demo01.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/query")
    public MessageUtil query(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        if (pn<0){
            pn=1;
        }
        List<Movie> movieList=movieService.findList();
        return MessageUtil.success().add("movie",movieList);
    }


    @RequestMapping("/search")
    public MessageUtil searchMovie(@RequestParam(value = "movieName")String movieName){

     return MessageUtil.success();
    }


    /**
     * 将网络上的电影信息插入数据库
     * @return
     */
    @RequestMapping("/insertByBatch")
    public MessageUtil insertMovieByBatch(@RequestParam(value = "indexUrl") String indexUrl) throws Exception {
        List<Movie> movieList=new ArrayList<>();

        SpiderMovieDetail detail=new SpiderMovieDetail();
        List<String> list = SpiderMovieList.getAllMovieUrl(10, indexUrl);

        for (int i = 0; i < list.size(); i++) {
            //获取详情页数据
            detail.search(list.get(i));
            movieList.add(detail.getMovie());
        }

        if (movieList.size()>0){
            for (Movie m:movieList){
                //查询数据库中是否有该电影信息
                Movie movie=movieService.findByMovieByName(m.getMovieName());
                if (movie!=null){
                    continue;
                }
                //插入数据库
                movieService.insertMovie(m);
            }
            return MessageUtil.success();
        }
        return MessageUtil.fail();
    }
}
