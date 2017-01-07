package com.lcc.controller;

import com.lcc.entity.Blog;
import com.lcc.entity.Comment;
import com.lcc.service.BlogService;
import com.lcc.service.CommentService;
import com.lcc.util.ResponseUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by lcc on 2017/1/7.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private BlogService blogService;

    public String save(Comment comment,
                       @RequestParam("imageCode")String imageCode,
                       HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session) throws Exception{

        String sRand = (String) session.getAttribute("sRand");
        JSONObject result = new JSONObject();
        int resultTotal = 0;

        if (! imageCode.equals(sRand)){
            result.put("success" , false);
            result.put("errorInfo" , "验证码错误");
        }else {
            String userIp = request.getRemoteAddr();
            comment.setUserIp(userIp);
            if(comment.getId() == null) {
                resultTotal = commentService.addComment(comment);
                Blog blog = blogService.findById(comment.getBlog().getId());
                blog.setReplyHit(blog.getReplyHit() + 1);
                blogService.update(blog);
            } else {

            }
        }

        if(resultTotal > 0) {
            result.put("success", true);
        }

        ResponseUtil.write(response, result);
        return null;

    }
}
