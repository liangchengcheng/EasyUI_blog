package com.lcc.controller.admin;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcc.entity.Blogger;
import com.lcc.service.BloggerService;
import com.lcc.util.CryptographyUtil;
import com.lcc.util.DateUtil;
import com.lcc.util.ResponseUtil;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

    @Resource
    private BloggerService bloggerService;

    @RequestMapping("/findBlogger")
    public String findBlogger(HttpServletResponse response) throws Exception{
        Blogger blogger = bloggerService.getBloggerData();
        JSONObject jsonObject = JSONObject.fromObject(blogger);
        ResponseUtil.write(response, jsonObject);
        return null;
    }

    //把上传的图片保存
    @RequestMapping("/save")
    public String save(
            @RequestParam("imageFile") MultipartFile imageFile,
            Blogger blogger,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        if(!imageFile.isEmpty()) {
            String filePath = request.getServletContext().getRealPath("/");
            String imageName = DateUtil.getCurrentDateStr() + "."
                    + imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath + "static/userImages/" + imageName));
            blogger.setImagename(imageName);
        }
        int resultTotal = bloggerService.updateBlogger(blogger);
        JSONObject result = new JSONObject();
        if(resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/modifyPassword")
    public String modifyPassword(
            @RequestParam("password") String password,
            HttpServletResponse response) throws Exception {

        Blogger blogger = new Blogger();
        blogger.setPassword(CryptographyUtil.md5(password, "javacoder"));
        int resultTotal = bloggerService.updateBlogger(blogger);
        JSONObject result = new JSONObject();
        if(resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        ResponseUtil.write(response, result);
        return null;
    }


    @RequestMapping("/logout")
    public String logout() throws Exception {

        SecurityUtils.getSubject().logout();
        return "redirect:/login.jsp";
    }
}
