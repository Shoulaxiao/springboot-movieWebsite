package com.shoulaxiao.demo01.common.movieSpider.spider01;

import com.shoulaxiao.demo01.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class MainRun {

    private static String INDEX_DYZZ = "https://www.dy2018.com/html/gndy/dyzz/index.html";
    private static final int N = 8;

    public static void main(String[] args) throws Exception {

        List<Movie> movieList = new ArrayList<>();

        SpiderMovieDetail detail = new SpiderMovieDetail();

        List<String> list = SpiderMovieList.getAllMovieUrl(2, INDEX_DYZZ);
        for (int i = 0; i < list.size(); i++) {
            //获取详情页数据
            detail.execute(list.get(i));
            movieList.add(detail.getMovie());
            System.out.println("**********爬取详情页**********" + i + "完成");
        }


        for (Movie movie : movieList) {
            System.out.println(movie);
        }
    }


    private static void getMovieDetail() throws InterruptedException {
        SpiderMovieList spiderMovieList = new SpiderMovieList();
        Vector<String> urlList = spiderMovieList.geturlList();
        CountDownLatch doneSignal = new CountDownLatch(N);
        CountDownLatch startSignal = new CountDownLatch(1);

        SpiderThread spiderThread = new SpiderThread(urlList, doneSignal, startSignal);
    }
}
