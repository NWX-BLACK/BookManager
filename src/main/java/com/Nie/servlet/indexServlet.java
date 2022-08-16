package com.Nie.servlet;

import com.Nie.service.UserServiceImpl;
import com.Nie.service.VerifyCodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
public class indexServlet {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Resource
    private VerifyCodeServiceImpl verifyCodeServiceImpl;

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request) {
        //1.删除session中的用户信息
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");

        return "redirect:/login/login";
    }

    @RequestMapping({"/","/login/login"})
    public String login(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
        String msg = "";
        if((msg = request.getParameter("msg")) !=null){
/*            if(msg.equals("用户名或密码错误")){
            }else {
                msg = URLDecoder.decode(msg,"UTF-8");
            }*/
            request.setAttribute("msg",msg);
        }

        //生成验证码并插入redis
        String verifyCode =  verifyCodeServiceImpl.insertVerifyCode(2*60);

        //页面显示验证码
        model.addAttribute("verifyCode",verifyCode);
//        System.out.println(verifyCode);

        String userName = "";
        String passWord = "";
        String ischecked = "";

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("loginUser")){
                String[] userNameAndPassword = URLDecoder.decode(cookie.getValue(),"utf-8").split("@");
                userName = userNameAndPassword[0];
                passWord = userNameAndPassword[1];
                ischecked = "checked";
            }
        }

        model.addAttribute("userName",userName);
        model.addAttribute("passWord",passWord);
        model.addAttribute("ischecked",ischecked);

        return "admin/login/login";
    }

    @RequestMapping("/login/toHome")
    public String toHome(HttpServletRequest request,
                         HttpServletResponse response,
                         RedirectAttributes attributes) throws UnsupportedEncodingException {

        String verifyCodeWeb = request.getParameter("verifyCode");
        String verifyCodeRedis = verifyCodeServiceImpl.queryVerifyCode("verifyCode");

        // 判断验证码是否正确
        String msg = "";
        if(verifyCodeWeb == null || verifyCodeWeb.equals("") || !verifyCodeWeb.equals(verifyCodeRedis)){
            if(verifyCodeWeb == null || verifyCodeWeb.equals("")){
                msg = "请输入验证码";
            }else{
                msg = "验证码错误";
            }
            return "redirect:/login/login?msg="+ URLEncoder.encode(msg,"UTF-8");
        }

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Cookie loginUser_cookie = new Cookie("loginUser", URLEncoder.encode(userName+"@"+passWord,"utf-8"));

        if(userName != null && userName !="" &&
                userServiceImpl.queryByUserName(userName) != null &&
                userServiceImpl.queryByUserName(userName).getPassWord().equals(passWord)){
            //登陆成功，保存用户信息

            HttpSession session = request.getSession();
            session.setAttribute("loginUser",userName);

            if("yes".equals(request.getParameter("remember"))){
                loginUser_cookie.setMaxAge(10*60);
            }else{
                loginUser_cookie.setMaxAge(0);
            }
            response.addCookie(loginUser_cookie);

            return "redirect:/login/home";
        }else{
            //登录失败,返回登录错误
            attributes.addAttribute("msg","用户名或密码错误");
            loginUser_cookie.setMaxAge(0);
            response.addCookie(loginUser_cookie);

            return "redirect:/login/login";
        }
    }

    @RequestMapping("/login/home")
    public String home() {

        return "admin/login/home";
    }

}
