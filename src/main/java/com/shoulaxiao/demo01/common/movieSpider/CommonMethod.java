package com.shoulaxiao.demo01.common.movieSpider;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class CommonMethod {

    public static String getHtmlPage(String url) throws Exception{
        String line;

        URL oul=new URL(url);
        URLConnection conn=oul.openConnection();//建立连接

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"gbk"));
        StringBuilder htmlpage=new StringBuilder();
        while ((line=bufferedReader.readLine())!=null){
            htmlpage.append(line);
        }

        return htmlpage.toString();
    }



}
