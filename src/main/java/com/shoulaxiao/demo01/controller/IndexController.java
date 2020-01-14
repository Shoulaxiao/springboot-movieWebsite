package com.shoulaxiao.demo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @USER: shoulaxiao
 * @DATE: 19-12-20
 * @TIME: 下午6:07
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
