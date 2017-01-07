package com.lcc.service.impl;

import com.lcc.dao.BlogDao;
import com.lcc.entity.Blog;
import com.lcc.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2017/1/7.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    public List<Blog> getBlogData() {
        return blogDao.getBlogData();
    }

    public List<Blog> listBlog(Map<String, Object> map) {
        return blogDao.listBlog(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return blogDao.getTotal(map);
    }

    public Blog findById(Integer id) {
        return blogDao.findById(id);
    }

    public Integer update(Blog blog) {
        return blogDao.update(blog);
    }

    public Blog getPrevBlog(Integer id) {
        return blogDao.getPrevBlog(id);
    }

    public Blog getNextBlog(Integer id) {
        return blogDao.getNextBlog(id);
    }

    public Integer addBlog(Blog blog) {
        return blogDao.addBlog(blog);
    }

    public Integer deleteBlog(Integer id) {
        return blogDao.deleteBlog(id);
    }

    public Integer getBlogByTypeId(Integer typeId) {
        return blogDao.getBlogByTypeId(typeId);
    }
}
