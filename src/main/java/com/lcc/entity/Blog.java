package com.lcc.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lcc on 2017/1/6.
 */
public class Blog {

    private Integer id;
    private String title;
    private String summary;
    private Date releaseDate;
    private Integer clickHit;
    private Integer replyHit;
    private String content;
    private String contentNoTag; //²»´ø±êÇ©µÄ²©¿ÍÄÚÈÝ£¬ÓÃÓÚLuceneË÷ÒýÖÐ
    private String keyWord; //¹Ø¼ü×Ö£¬ÓÃ¿Õ¸ñ¸ô¿ª

    private BlogType blogType; //²©¿ÍÀàÐÍ
    private Integer blogCount; //²©¿ÍÊýÁ¿£¬·Ç²©¿ÍÊµ¼ÊÊôÐÔ£¬ÓÃÓÚ¸ù¾Ý·¢²¼ÈÕÆÚ¹éµµ²éÑ¯
    private String releaseDateStr; //·¢²¼ÈÕÆÚµÄ×Ö·û´®£¬Ö»È¡ÄêÔÂ

    private List<String> imageList = new LinkedList<String>();//²©¿ÍÀï´æµÄÍ¼Æ¬£¬Ö÷ÒªÓÃÓÚÕ¹Ê¾ËõÂÔÍ¼

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getContentNoTag() {
        return contentNoTag;
    }

    public void setContentNoTag(String contentNoTag) {
        this.contentNoTag = contentNoTag;
    }
}
