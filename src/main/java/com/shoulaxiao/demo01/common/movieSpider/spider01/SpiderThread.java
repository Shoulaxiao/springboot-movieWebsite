package com.shoulaxiao.demo01.common.movieSpider.spider01;

import com.shoulaxiao.demo01.entity.Movie;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @USER: shoulaxiao
 * @DATE: 20-1-14
 * @TIME: 下午2:34
 **/
public class SpiderThread implements Runnable {

    //线程开始结束的信号
    private final CountDownLatch doneSignal;
    private final CountDownLatch startSignal;

    private static Vector<String> urlList;
    private static Set<Movie> movieSet = new HashSet<>();

    private static int i = 0;

    /**
     * 构造函数
     *
     * @param urlList     电影详情列表url
     * @param doneSignal
     * @param startSignal
     */
    public SpiderThread(Vector<String> urlList, CountDownLatch doneSignal, CountDownLatch startSignal) {
        this.doneSignal = doneSignal;
        this.startSignal = startSignal;
        SpiderThread.urlList = urlList;
    }

    @Override
    public void run() {
        try {
            //等待开始执行信号的发布
            startSignal.await();
            SpiderMovieDetail spider = new SpiderMovieDetail();
            while (!urlList.isEmpty()) {
                String url_temp = getOneUrl();
                if (url_temp != null) {
                    try {
                        System.out.println(i + ":" + url_temp);
                        i++;
                        spider.execute(url_temp);
                        movieSet.add(spider.getMovie());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            doneSignal.countDown();
        }
    }


    /**
     * 得到一条url路径
     *
     * @return
     */
    private synchronized String getOneUrl() {
        if (urlList.isEmpty()) {
            return null;
        }
        String temp = urlList.get(0);
        urlList.remove(0);
        return temp;
    }

    /**
     * 返回结果
     *
     * @return
     */
    public Set<Movie> getMovies() {
        return movieSet;
    }
}
