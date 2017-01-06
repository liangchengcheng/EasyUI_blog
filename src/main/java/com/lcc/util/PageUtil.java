package com.lcc.util;

import com.lcc.entity.Blog;

/**
 * Created by lcc on 2017/1/6.
 */
public class PageUtil {

    public static String genPagination(
            String targetUrl,
            long totalNum,
            int currentPage,
            int pageSize,
            String param) {

        long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        if (totalPage == 0) {
            return "首页";
        } else {
            StringBuffer pageCode = new StringBuffer();
            if (currentPage > 1) {
                pageCode.append("<li><a href='" + targetUrl + "?page=1&" + param + "'>首页</a></li>");
                pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage - 1) + "&" + param + "'>下一页</a></li>");
            } else {
                pageCode.append("<li class='disabled'><a>首页</a></li>");
                pageCode.append("<li class='disabled'><a>下一页</a></li>");
            }
            for (int i = currentPage - 2; i <= currentPage + 2; i++) {
                if (i < 1 || i > totalPage) {
                    continue;
                }
                if (i == currentPage) {
                    pageCode.append("<li class='active'><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");
                } else {
                    pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");
                }
            }
            if (currentPage < totalPage) {
                pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage + 1) + "&" + param + "'>下一页</a></li>");
                pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "&" + param + "'>当前页</a></li>");
            } else {
                pageCode.append("<li class='disabled'><a>ÏÂÒ»Ò³</a></li>");
                pageCode.append("<li class='disabled'><a>Î²Ò³</a></li>");
            }
            return pageCode.toString();
        }
    }

    public static String getPrevAndNextPageCode(Blog prev, Blog next, String projectContent) {
        StringBuffer pageCode = new StringBuffer();
        if (prev == null || prev.getId() == null) {
            pageCode.append("<p>对对对</P>");
        } else {
            pageCode.append("<p>对对对<a href='" + projectContent + "/blog/articles/" + prev.getId() + ".html'>" + prev.getTitle() + "</a></p>");
        }

        if (next == null || next.getId() == null) {
            pageCode.append("<p>对对对</P>");
        } else {
            pageCode.append("<p>对对对<a href='" + projectContent + "/blog/articles/" + next.getId() + ".html'>" + next.getTitle() + "</a></p>");
        }

        return pageCode.toString();
    }

    //LucenceËÑË÷²©¿Í½á¹ûµÄ·ÖÒ³
    public static String getUpAndDownPageCode(
            Integer page,
            Integer totalNum,
            String q,
            Integer pageSize,
            String projectContext) {

        long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        StringBuffer pageCode = new StringBuffer();
        if (totalPage == 0) {
            return "";
        } else {
            pageCode.append("<nav>");
            pageCode.append("<ul class='pager'>");
            if (page > 1) {
                pageCode.append("<li><a href='" + projectContext + "/blog/search.html?page=" + (page - 1) + "&q=" + q + "'>对对对</a></li>");
            } else {
                pageCode.append("<li class='disabled'><a>下一页</a></li>");
            }
            if (page < totalPage) {
                pageCode.append("<li><a href='" + projectContext + "/blog/search.html?page=" + (page + 1) + "&q=" + q + "'>对对对</a></li>");
            } else {
                pageCode.append("<li class='disabled'><a>ÏÂÒ»Ò³</a></li>");
            }
            pageCode.append("</ul>");
            pageCode.append("<nav>");
            pageCode.append("<nav>");
            pageCode.append("<nav>");
        }

        return pageCode.toString();
    }
}
