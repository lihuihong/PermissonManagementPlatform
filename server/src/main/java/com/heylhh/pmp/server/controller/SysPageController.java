package com.heylhh.pmp.server.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author heylhh
 * @Description //页面跳转
 * @Date 18:02 2019/10/26
 * @Param
 * @return
 **/
@Controller
public class SysPageController {

    @RequestMapping("modules/{module}/{page}.html")
    public String page(@PathVariable String module, @PathVariable String page){
        return "modules/"+module+"/"+page;
    }


    @RequestMapping(value = {"index.html","/"} )
    public String index(){
        return "index";
    }

    @RequestMapping("login.html")
    public String login(){
        if (SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:index.html";
        }
        return "login";
    }

    @RequestMapping("main.html")
    public String main(){
        return "main";
    }

    @RequestMapping("404.html")
    public String notFound(){
        return "404";
    }


}