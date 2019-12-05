package com.shoulaxiao.demo01.common.movieSpider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 爬取分页信息列表，存储在List里面并返回
 */
public class SpiderMovieList extends SpiderCommon {

    private static List<String> uList =new ArrayList<String>();

    @Override
    public void search(String url) throws Exception {
        //获取Url地址获取网页内容
        String htmlPage = CommonMethod.getHtmlPage(url);

        if (htmlPage!=null){
            Document docx= Jsoup.parse(htmlPage);
            Elements htmltable=docx.select("table.tbspan");

            Elements links=htmltable.select("a[href]");

            for (Element link : links) {
                String linkHref = link.attr("href");
                uList.add("https://www.dy2018.com"+linkHref);
            }
        }
    }


    public  List<String> getuList() {
        return uList;
    }

    public static List getAllMovieUrl(int n,String indexUrl) throws Exception {
        Integer i=1;
        SpiderMovieList spiderMovieList=new SpiderMovieList();
        System.out.println("***********开始爬取列表信息**********");
        spiderMovieList.search(indexUrl);//爬取第一页
        for (i=2;i<n;i++){
            String url=indexUrl.replace("index_",("index_"+i.toString()));
            spiderMovieList.search(url);
            System.out.println("info"+"爬取第"+i+"页");
        }
        System.out.println("********列表页爬取成功********");
        List<String> resultList=spiderMovieList.getuList();
        return resultList;
    }
}
