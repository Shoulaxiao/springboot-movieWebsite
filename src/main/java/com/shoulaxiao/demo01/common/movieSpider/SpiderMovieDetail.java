package com.shoulaxiao.demo01.common.movieSpider;

import com.shoulaxiao.demo01.entity.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class SpiderMovieDetail extends SpiderCommon {

    private Movie movie;

    @Override
    public void search(String url) throws Exception {
        movie=new Movie();

        String htmlPage=CommonMethod.getHtmlPage(url);
        if (htmlPage!=null){

            Document doc= Jsoup.parse(htmlPage);

            Element link=doc.select("div.title_all").last();
            if (link!=null){
                String title=link.text();
                //获取链接
                Elements elements = doc.select("div#Zoom");

                System.out.println(elements);

                Element element = elements.select("a[href]").first();
                System.out.println(element);
                if(element!=null){
                    String href = element.attr("href");
                    movie.setDownloadUrl(href);
                }
                movie.setMovieName(title);
            }
        }
    }

    public Movie getMovie() {
        return movie;
    }
}
