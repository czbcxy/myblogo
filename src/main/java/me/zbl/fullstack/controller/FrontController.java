package me.zbl.fullstack.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import me.zbl.fullstack.controller.base.BaseController;
import me.zbl.fullstack.entity.Tag;
import me.zbl.fullstack.service.api.IAdminBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 前台页面控制器
 *
 * @author czb
 */
@Controller
public class FrontController extends BaseController {

  @Autowired
  private IAdminBlogService mBlogService;

  /**
   * 错误页
   */
  @GetMapping("/error")
  public String pErrorPage(HttpServletRequest request, Model model) {
    return "error";
  }

//  /**
//   * 前台首页
//   * GET
//   */
    @GetMapping("/post")
    public String pFrontIndex(HttpServletRequest request, Model model) {
      return "posts";
    }

  /**
   * 获取tags
   * POST
   */
  @GetMapping("/tags")
  @ResponseBody
  public List<Tag> pFrontIndexPost() {
    List<Tag> list = mBlogService.blogSelectTags();
    return list;
  }

  /**
   * 前台用户登录页
   */
  @GetMapping("/userlogin")
  public String pFrontUserLogin(HttpServletRequest request, Model model) {
    return "userlogin";
  }

  /**
   * 前台用户注册
   */
  @GetMapping("/userregister")
  public String pFrontUserRegister(HttpServletRequest request, Model model) {
    return "register";
  }

}
