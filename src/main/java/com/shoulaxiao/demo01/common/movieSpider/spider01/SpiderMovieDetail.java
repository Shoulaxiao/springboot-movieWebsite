package com.shoulaxiao.demo01.common.movieSpider.spider01;

import com.shoulaxiao.demo01.entity.Actor;
import com.shoulaxiao.demo01.entity.Director;
import com.shoulaxiao.demo01.entity.Movie;
import com.shoulaxiao.demo01.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class SpiderMovieDetail extends SpiderCommon {

    private Movie movie;

    @Override
    public void execute(String url) throws Exception {
        movie=new Movie();

        String htmlPage=CommonMethod.getHtmlPage(url);
        if (htmlPage!=null){
            Document doc= Jsoup.parse(htmlPage);

            //获取电影的标题
            Elements link=doc.select("div.title_all");
            if (link!=null){
                String title=link.text();
                movie.setMovieName(StringUtil.getTile(title));
            }

            //获取其他电影信息
            Elements elements=doc.select("div#Zoom");

            //获取电影的海报
            Elements eleImg=elements.select("img");
            if (!eleImg.isEmpty()){
                movie.setImgUrl(eleImg.get(0).attr("src"));
            }

            //获取文本信息
            String temp=elements.text();
            String[] content=temp.split("◎");
            for (String s:content){
                //截取年代
                if(s.contains("年　　代")){
                    movie.setYears(s.substring(5, s.length()).trim());
                }

                //截取产地
                if(s.contains("产　　地")||s.contains("国　　家")){
                    movie.setPlaceOrigin(s.substring(5, s.length()).trim());
                }

                //截取类别
                if (s.contains("类　　别")){
                    movie.setCategory(s.substring(5,s.length()).trim());
                }

                //截取语言
                if (s.contains("语　　言")){
                    movie.setLanguage(s.substring(5,s.length()).trim());
                }

                //截取上映日期
                if (s.contains("上映日期")){
                    movie.setReleaseDate(s.substring(5,s.length()).trim());
                }

                //截取豆瓣评分
                if (s.contains("豆瓣评分")){
                    movie.setBeanSocre(s.substring(5,s.length()).trim());
                }

                //截取IMDB评分
                if (s.contains("IMDb评分")){
                    movie.setImdbSocre(s.substring(6,s.length()).trim());
                }

                //截取文件格式
                if (s.contains("文件格式")){
                    movie.setFileFormat(s.substring(5,s.length()).trim());
                }

                //截取视频尺寸
                if (s.contains("视频尺寸")){
                    movie.setVedioSzie(s.substring(5,s.length()).trim());
                }

                //截取片长度
                if (s.contains("片　　长")){
                    movie.setSheelLenth(s.substring(5,s.length()).trim());
                }

                //截取导演
                if (s.contains("导　　演")){
                    Director director=null;
                    List<Director> directorList=new ArrayList<>();
                    String[] directors=s.split("\\s+");
                    for (String d:directors){
                        if (d.equals("导")||d.equals("演")){
                            continue;
                        }
                        director=new Director();
                        director.setName(d);
                        directorList.add(director);
                    }
                    movie.setDirectors(directorList);
                }

                //截取主演，使用List存储
                if (s.contains("主　　演")){
                    Actor actor=null;
                    List<Actor> actorsList=new ArrayList<>();
                    String[] actors=s.split("\\s+");
                    for (String a:actors){
                        actor=new Actor();
                        if (a.contains(" ")){
                            continue;
                        }
                        if (a.contains("主　　演")){
                            actor.setActName(a.trim());
                        }
                        actor.setActName(a.trim());
                        actorsList.add(actor);
                    }
                    movie.setActors(actorsList);
                }

                //截取简介
                if (s.contains("◎简　　介")){
                    movie.setBriefIntoduction(s.substring(5,s.length()));
                }
            }
        }
    }


    public Movie getMovie() {
        return movie;
    }
}
