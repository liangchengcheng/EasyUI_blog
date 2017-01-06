package com.lcc.entity;

/**
 * Created by lcc on 2017/1/6.
 */
public class BlogType {

    private Integer id;
    private String typeName;
    private String orderNum;

    private Integer blogCount;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
    public Integer getBlogCount() {
        return blogCount;
    }
    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }
}
