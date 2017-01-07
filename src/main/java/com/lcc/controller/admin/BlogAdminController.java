package com.lcc.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.lcc.entity.Blog;
import com.lcc.entity.Comment;
import com.lcc.entity.PageBean;
import com.lcc.lucene.BlogIndex;
import com.lcc.service.BlogService;
import com.lcc.service.BloggerService;
import com.lcc.service.CommentService;
import com.lcc.util.DateJsonValueProcessor;
import com.lcc.util.ResponseUtil;
import com.lcc.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lcc on 2017/1/7.
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
    @Resource
    private BlogService blogService;

    @Resource
    private CommentService commentService;

    private BlogIndex blogIndex = new BlogIndex();

    @RequestMapping("/save")
    public String save(Blog blog,HttpServletResponse response)throws Exception{

        int resultTotal = 0;
        if (blog.getId() == null){
            resultTotal = blogService.addBlog(blog);
            blogIndex.addIndex(blog);
        }else {
            resultTotal = blogService.update(blog);
            blogIndex.updateIndex(blog);
        }

        JSONObject result = new JSONObject();
        if(resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/listBlog")
    public String listBlog(
            @RequestParam(value="page", required=false)String page,
            @RequestParam(value="rows", required=false)String rows,
            Blog s_blog,
            HttpServletResponse response) throws Exception {

        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", StringUtil.formatLike(s_blog.getTitle())); //Ä£ºý²éÑ¯
        map.put("start", pageBean.getStart());
        map.put("pageSize", pageBean.getPageSize());
        List<Blog> blogList = blogService.listBlog(map);
        Long total = blogService.getTotal(map);

        JSONObject result = new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();

        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONArray jsonArray = JSONArray.fromObject(blogList, jsonConfig);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/delete")
    public String deleteBlog(
            @RequestParam(value="ids", required=false)String ids,
            HttpServletResponse response) throws Exception {

        String[] idsStr = ids.split(",");
        for(int i = 0; i < idsStr.length; i++) {
            int id = Integer.parseInt(idsStr[i]);
            commentService.deleteCommentByBlogId(id);
            blogService.deleteBlog(id);
            blogIndex.deleteIndex(idsStr[i]);
        }
        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/findById")
    public String findById(
            @RequestParam(value="id", required=false)String id,
            HttpServletResponse response) throws Exception {

        Blog blog = blogService.findById(Integer.parseInt(id));
        JSONObject result = JSONObject.fromObject(blog);
        ResponseUtil.write(response, result);
        return null;
    }
}
