package com.shoulaxiao.demo01;

import com.shoulaxiao.demo01.common.movieSpider.spider01.SpiderMovieDetail;
import com.shoulaxiao.demo01.common.movieSpider.spider01.SpiderMovieList;
import com.shoulaxiao.demo01.entity.Actor;
import com.shoulaxiao.demo01.entity.Movie;
import com.shoulaxiao.demo01.entity.MovieActorConfig;
import com.shoulaxiao.demo01.service.ActorService;
import com.shoulaxiao.demo01.service.MovieActorConfigService;
import com.shoulaxiao.demo01.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Demo01ApplicationTests {

    @Autowired
    private MovieActorConfigService movieActorConfigService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorService actorService;

    @Test
    void contextLoads() {

    }

    @Test
    void testmovieConfig(){
        List<MovieActorConfig> movieActorConfigDaoList=movieActorConfigService.getAll();
        if (movieActorConfigDaoList.size()!=0){
            for (MovieActorConfig m:movieActorConfigDaoList){
                System.out.println(m);
            }
        }else {
            System.out.println("没有查询到");
        }
    }


    @Test
    void testquryMovie(){
        List<Movie> movieList=movieService.findList();
        for (Movie m:movieList){
            System.out.println(m);
        }
    }

    @Test
    void testquryActor(){
        List<Actor> list=actorService.getAll();
        for(Actor actor:list){
            System.out.println(actor);
        }
    }

    @Test
    void tetsMovieByBatch() throws Exception{

        String INDEX_DYZZ="https://www.dy2018.com/html/gndy/dyzz/index.html";
        List<Movie> movieList=new ArrayList<>();

        SpiderMovieDetail detail=new SpiderMovieDetail();

        List<String> list = SpiderMovieList.getAllMovieUrl(10, INDEX_DYZZ);

        for (int i = 0; i < list.size(); i++) {
            //获取详情页数据
            detail.search(list.get(i));
            movieList.add(detail.getMovie());
            System.out.println("**********爬取详情页**********"+i+"完成");
        }


        for (Movie m:movieList){
            System.out.println(m.getBriefIntoduction());
            Movie mm=movieService.findByMovieByName(m.getMovieName());
            if (mm!=null){
                continue;
            }
            movieService.insertMovie(m);
        }
    }

    void testSelectMovieByName(){
        String name="犯罪现场";
        Movie movie=movieService.findByMovieByName(name);
        System.out.println(movie);
    }

    @Test
    void TestSpit(){
        Actor actor=actorService.getActorByName("吴京");
        System.out.println(actor);
    }


    @Test
    public void testStart(){
        testSelectMovieByName();
    }

}
