package com.lcc.controller;

import com.lcc.entity.Blog;
import com.lcc.entity.PageBean;
import com.lcc.service.BlogService;
import com.lcc.util.PageUtil;
import com.lcc.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lcc on 2017/1/7.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private BlogService blogService;

    @RequestMapping("/index")
    public ModelAndView index(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "typeId", required = false) String typeId,
            @RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
            HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        if (StringUtil.isEmpty(page)) {
            page = "1";
        }

        PageBean pageBean = new PageBean(Integer.parseInt(page),10);
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("pageSize", pageBean.getPageSize());
        map.put("typeId", typeId);
        map.put("releaseDateStr", releaseDateStr);


        List<Blog> blogList = blogService.listBlog(map);

        for (Blog blog : blogList){
            List<String> imageList = blog.getImageList();
            String blogInfo = blog.getContent();
            Document doc = Jsoup.parse(blogInfo);
            Elements jpgs = doc.select("img[src$=.jpg]");
            for(int i = 0; i < jpgs.size(); i++) {
                Element jpg = jpgs.get(i);
                imageList.add(jpg.toString());
                if(i == 2)
                    break;
            }
        }


        StringBuffer param = new StringBuffer();

        if(StringUtil.isNotEmpty(typeId)) {
            param.append("typeId=" + typeId + "&");
        }
        if(StringUtil.isNotEmpty(releaseDateStr)) {
            param.append("releaseDateStr=" + releaseDateStr + "&");
        }

        modelAndView.addObject("pageCode", PageUtil.genPagination(
                request.getContextPath() + "/index.html",
                blogService.getTotal(map),
                Integer.parseInt(page), 10,
                param.toString()));

        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("commonPage", "foreground/blog/blogList.jsp");
        modelAndView.addObject("title", "标题");
        modelAndView.setViewName("mainTemp");

        return modelAndView;
    }

}
