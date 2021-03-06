package com.lcc.service.impl;

import com.lcc.dao.BlogTypeDao;
import com.lcc.entity.BlogType;
import com.lcc.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2017/1/7.
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeDao blogTypeDao;

    public List<BlogType> getBlogTypeData() {
        return blogTypeDao.getBlogTypeData();
    }

    public List<BlogType> listBlogType(Map<String, Object> map) {
        return blogTypeDao.listBlogType(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return blogTypeDao.getTotal(map);
    }

    public Integer addBlogType(BlogType blogType) {
        return blogTypeDao.addBlogType(blogType);
    }

    public Integer updateBlogType(BlogType blogType) {
        return blogTypeDao.updateBlogType(blogType);
    }

    public Integer deleteBlogType(Integer id) {
        return blogTypeDao.deleteBlogType(id);
    }

}
