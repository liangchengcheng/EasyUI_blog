package com.lcc.service.impl;

import com.lcc.dao.BloggerDao;
import com.lcc.entity.Blogger;
import com.lcc.service.BloggerService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by lcc on 2017/1/7.
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerDao bloggerDao;

    public Blogger getByUsername(String username) {
        return bloggerDao.getByUsername(username);
    }

    public Blogger getBloggerData() {
        return bloggerDao.getBloggerData();
    }

    public Integer updateBlogger(Blogger blogger) {
        return bloggerDao.updateBlogger(blogger);
    }
}
