package com.lcc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.lcc.entity.Blogger;
import com.lcc.service.BloggerService;
import com.lcc.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lcc on 2017/1/7.
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @Resource
    private BloggerService bloggerService;

    @RequestMapping("/login")
    public String login(Blogger blogger, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        String newPassword = CryptographyUtil.md5(blogger.getPassword(), "javacoder");
        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(), newPassword);
        try {
            subject.login(token);
            return "redirect:/admin/main.jsp";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            request.setAttribute("bloger", blogger);
            request.setAttribute("errorInfo", "login error");
            return "login";
        }
    }

    @RequestMapping("/aboutme")
    public ModelAndView abouotMe() {
        ModelAndView modelAndView = new ModelAndView();
        Blogger blogger = bloggerService.getBloggerData();
        modelAndView.addObject("blogger", blogger);
        modelAndView.addObject("commonPage", "foreground/blogger/bloggerInfo.jsp");
        modelAndView.addObject("title", "标题");
        modelAndView.setViewName("mainTemp");
        return modelAndView;
    }

    @RequestMapping("/myalbum")
    public ModelAndView myAlbum() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("commonPage", "foreground/blogger/myAlbum.jsp");
        modelAndView.setViewName("mainTemp");
        return modelAndView;
    }

    @RequestMapping("/resource")
    public ModelAndView resource() {
        ModelAndView modelAndView = new ModelAndView();
        //....
        modelAndView.addObject("commonPage", "foreground/blogger/resource.jsp");
        modelAndView.setViewName("mainTemp");
        return modelAndView;
    }
}
