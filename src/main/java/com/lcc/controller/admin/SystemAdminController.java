package com.lcc.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcc.entity.Blog;
import com.lcc.entity.BlogType;
import com.lcc.entity.Blogger;
import com.lcc.entity.Link;
import com.lcc.service.BlogService;
import com.lcc.service.BlogTypeService;
import com.lcc.service.BloggerService;
import com.lcc.service.LinkService;
import com.lcc.util.ResponseUtil;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Created by lcc on 2017/1/7.
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {
    @Resource
    private BloggerService bloggerService;
    @Resource
    private LinkService linkService;
    @Resource
    private BlogTypeService blogTypeService;
    @Resource
    private BlogService blogService;

    @RequestMapping("/refreshSystemCache")
    public String refreshSystemCache(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ServletContext application =
                RequestContextUtils.getWebApplicationContext(request).getServletContext();

        Blogger blogger = bloggerService.getBloggerData();
        blogger.setPassword(null);
        application.setAttribute("blogger", blogger);

        List<Link> linkList = linkService.getLinkData();
        application.setAttribute("linkList", linkList);

        List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
        application.setAttribute("blogTypeList", blogTypeList);

        List<Blog> blogTimeList = blogService.getBlogData();
        application.setAttribute("blogTimeList", blogTimeList);

        JSONObject result = new JSONObject();
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

}
