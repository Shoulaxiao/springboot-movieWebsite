package com.shoulaxiao.demo01.common.movieSpider.spider01;

import com.shoulaxiao.demo01.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainRun {

    private static String INDEX_DYZZ="https://www.dy2018.com/html/gndy/dyzz/index.html";

    public static void main(String[] args) throws Exception {

        List<Movie> movieList=new ArrayList<>();

        SpiderMovieDetail detail=new SpiderMovieDetail();

        List<String> list = SpiderMovieList.getAllMovieUrl(2, INDEX_DYZZ);
        for (int i = 0; i < list.size(); i++) {
            //获取详情页数据
            detail.search(list.get(i));
            movieList.add(detail.getMovie());
            System.out.println("**********爬取详情页**********"+i+"完成");
        }


        for (Movie movie:movieList){
            System.out.println(movie);
        }

    }
}
