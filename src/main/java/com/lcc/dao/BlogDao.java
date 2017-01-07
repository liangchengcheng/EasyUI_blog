package com.lcc.dao;

import com.lcc.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2017/1/7.
 */
public interface BlogDao {

    public List<Blog> getBlogData();

    public List<Blog> listBlog(Map<String, Object> map);

    public Long getTotal(Map<String, Object> map);

    public Blog findById(Integer id);

    public Integer update(Blog blog);

    public Blog getPrevBlog(Integer id);

    public Blog getNextBlog(Integer id);

    public Integer addBlog(Blog blog);

    public Integer deleteBlog(Integer id);

    public Integer getBlogByTypeId(Integer typeId);
}
