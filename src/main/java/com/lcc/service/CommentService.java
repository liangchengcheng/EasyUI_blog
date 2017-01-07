package com.lcc.service;

import com.lcc.entity.Comment;

import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2017/1/7.
 */
public interface CommentService {
    public List<Comment> getCommentData(Map<String, Object> map);

    public int addComment(Comment comment);

    public Long getTotal(Map<String, Object> map);

    public Integer update(Comment comment);

    public Integer deleteComment(Integer id);

    public Integer deleteCommentByBlogId(Integer blogId);
}
