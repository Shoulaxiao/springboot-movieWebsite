package com.shoulaxiao.demo01.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: guozhonghao
 * Date: 2019/12/6
 * Time: 16:41
 * Description: 处理字符串工具类
 */
public class StringUtil {

    //匹配书名号的内容
    static Pattern pattern = Pattern.compile("《(.*?)》");

    /**
     *得到书名号中间的字符串
     * @param str
     * @return
     */
    public static String getTile(String str){
        Matcher matcher=pattern.matcher(str);
        String result=null;
        while (matcher.find()) {
            result= matcher.group(1);
        }
        return result;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean boolIsEmpty(String str){
        boolean isFlag=true;
        if (str==null||" ".equals(str)){
            isFlag=false;
        }
        return isFlag;
    }


}
