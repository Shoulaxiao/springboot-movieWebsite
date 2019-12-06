package com.shoulaxiao.demo01.util;

import java.util.HashMap;
import java.util.Map;


/**
 * 用户包数据，返回给前端
 */
public class MessageUtil {

    //状态码
    private int code;
    //提示信息
    private String msg;
    private Map<String,Object> extend=new HashMap<String, Object>();

    public static MessageUtil success(){
        MessageUtil result=new MessageUtil();
        result.setCode(100);
        result.setMsg("处理成功！");
        return result;
    }

    public static MessageUtil fail(){
        MessageUtil result=new MessageUtil();
        result.setCode(200);
        result.setMsg("处理失败！");
        return result;
    }

    public static MessageUtil fail(String msg){
        MessageUtil result=new MessageUtil();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }

    public MessageUtil add(String key, Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}