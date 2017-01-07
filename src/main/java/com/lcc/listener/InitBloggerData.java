package com.lcc.listener;

import com.lcc.entity.Blog;
import com.lcc.entity.BlogType;
import com.lcc.entity.Blogger;
import com.lcc.entity.Link;
import com.lcc.service.BlogService;
import com.lcc.service.BlogTypeService;
import com.lcc.service.BloggerService;
import com.lcc.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by lcc on 2017/1/7.
 */
public class InitBloggerData implements ServletContextListener,ApplicationContextAware {
    private static ApplicationContext applicationContext;


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application  = servletContextEvent.getServletContext();

        BloggerService bloggerService = (BloggerService) applicationContext.getBean("bloggerService");;

        Blogger blogger = bloggerService.getBloggerData();
        blogger.setPassword(null);
        application.setAttribute("blogger",blogger);

        LinkService linkService = (LinkService) applicationContext.getBean("linkService");
        List<Link> linkList = linkService.getLinkData();
        application.setAttribute("linkList",linkList);


        BlogTypeService blogTypeService = (BlogTypeService) applicationContext.getBean("blogTypeService");
        List<BlogType>  blogTypeList = blogTypeService.getBlogTypeData();
        application.setAttribute("blogTypeList",blogTypeList);


        BlogService blogService = (BlogService) applicationContext.getBean("blogService");
        List<Blog> blogTimeList = blogService.getBlogData();
        application.setAttribute("blogTimeList", blogTimeList);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InitBloggerData.applicationContext = applicationContext;
    }
}
