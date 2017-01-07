package com.lcc.service;

import com.lcc.entity.BlogType;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2017/1/7.
 */
public interface BlogTypeService {

    public List<BlogType> getBlogTypeData();

    public List<BlogType> listBlogType(Map<String, Object> map);

    public Long getTotal(Map<String, Object> map);

    public Integer addBlogType(BlogType blogType);

    public Integer updateBlogType(BlogType blogType);

    public Integer deleteBlogType(Integer id);
}
