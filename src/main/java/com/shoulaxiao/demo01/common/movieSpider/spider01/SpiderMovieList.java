package com.shoulaxiao.demo01.common.movieSpider.spider01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 爬取分页信息列表，存储在List里面并返回
 */
public class SpiderMovieList extends SpiderCommon {

    private static Vector<String> urlList = new Vector<>();

    @Override
    public void execute(String url) throws Exception {
        //获取Url地址获取网页内容
        String htmlPage = CommonMethod.getHtmlPage(url);

        if (htmlPage != null) {
            Document docx = Jsoup.parse(htmlPage);
            Elements htmltable = docx.select("table.tbspan");
            Elements links = htmltable.select("a[href]");
            for (Element link : links) {
                String linkHref = link.attr("href");
                urlList.add("https://www.dy2018.com" + linkHref);
            }
        } else {
            throw new RuntimeException("无法获取url网址内容");
        }
    }


    public Vector<String> geturlList() {
        return urlList;
    }

    public static Vector<String> getAllMovieUrl(int n, String indexUrl) throws Exception {

        SpiderMovieList spiderMovieList = new SpiderMovieList();
        System.out.println("开始爬取列表信息**********");
        //爬取第一页
        spiderMovieList.execute(indexUrl);
        Integer i = 1;
        for (i = 2; i < n; i++) {
            String url = indexUrl.replace("index", ("index_" + i.toString()));
            spiderMovieList.execute(url);
            System.out.println("info" + "爬取第" + i + "页...");
        }
        System.out.println("列表页爬取成功********");
        return spiderMovieList.geturlList();
    }
}
