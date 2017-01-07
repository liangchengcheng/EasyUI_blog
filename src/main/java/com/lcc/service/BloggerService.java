package com.lcc.service;

import com.lcc.entity.Blogger;

/**
 * Created by lcc on 2017/1/7.
 */
public interface BloggerService {

    public Blogger getByUsername(String username);

    public Blogger getBloggerData();

    public Integer updateBlogger(Blogger blogger);
}
