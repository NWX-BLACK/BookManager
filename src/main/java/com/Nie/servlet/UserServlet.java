package com.Nie.servlet;

import com.Nie.pojo.User;
import com.Nie.service.UserServiceImpl;
import com.Nie.service.VerifyCodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
import java.util.Date;

@Controller
public class UserServlet {

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

    @GetMapping({"/","/login/login"})
    public String login(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
        String msg = "";
        if((msg = request.getParameter("msg")) !=null){
            request.setAttribute("msg",msg);
        }

        //生成验证码并插入redis
        String verifyCode =  verifyCodeServiceImpl.insertVerifyCode(2*60);
        System.out.println("生成的验证码："+verifyCode);

        //页面显示验证码
        request.setAttribute("verifyCode",verifyCode);
        System.out.println("显示验证码"+request.getAttribute("verifyCode"));

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


    @RequestMapping("/toRegister")
    public String toRegister(@Nullable @RequestParam("error") String error, HttpServletRequest request,
                             Model model) {

        String registerName = "";
        String registerWord = "";
        String registerWordAgain = "";

        if(error != null) {
            model.addAttribute("error", error);
        }

        HttpSession session = request.getSession();
        String newUser = (String) (session.getAttribute("newUser"));
        if(newUser != null){
            String[] newUserInfo = newUser.split("-");
            registerName = newUserInfo[0];
            registerWord = newUserInfo[1];
            registerWordAgain = newUserInfo[2];
        }

        model.addAttribute("registerName",registerName);
        model.addAttribute("registerWord",registerWord);
        model.addAttribute("registerWordAgain",registerWordAgain);
        session.removeAttribute("newUser");

//        System.out.println(error);
        return "admin/login/register";
    }


    @RequestMapping("/register")
    public String register(@RequestParam("registerName") String registerName,@RequestParam("registerWord") String  registerWord,
                           @RequestParam("registerWordAgain") String  registerWordAgain,HttpServletRequest request,
                           Model model) throws UnsupportedEncodingException {

        //1.查询当前用户名存不存在
        User user = userServiceImpl.queryByUserName(registerName);
        String error = "";
        if(user != null){
            //用户已存在，输出错误信息
            System.out.println("该账号已存在！");
            error = "该账号已存在！";
//            model.addAttribute("error", "该账号已存在！");
        }else{
            //用户未存在，
            //先判断两次密码输入是否一致
            if(!registerWordAgain.equals(registerWord)){
                System.out.println("两次密码输入不一致");
                error = "两次密码输入不一致";
//                model.addAttribute("error", "两次密码输入不一致");
            }else{
                userServiceImpl.insertUser(new User(null,registerName,registerWord,null));
                model.addAttribute("error", "恭喜您，注册成功！");
                return "redirect:/login/login";
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("newUser",registerName+"-"+registerWord+"-"+registerWordAgain);
        return "redirect:/toRegister?error="+URLEncoder.encode(error,"utf-8");
    }


    @RequestMapping("/login/toHome")
    public String toHome(HttpServletRequest request,
                         HttpServletResponse response,
                         RedirectAttributes attributes) throws UnsupportedEncodingException {

        String verifyCodeWeb = request.getParameter("verifyCode");
        String verifyCodeRedis = verifyCodeServiceImpl.queryVerifyCode("verifyCode");

        String verifyCode =  verifyCodeServiceImpl.insertVerifyCode(2*60);
        System.out.println("生成的验证码2："+verifyCode);

        System.out.println(verifyCodeWeb);
        System.out.println("查询出的验证码："+verifyCodeRedis);

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


    @RequestMapping("/toModifyPassWord")
    public String toModifyPassWord(@Nullable @RequestParam("error") String error ,Model model){

        if(error != null) {
            model.addAttribute("error", error);
        }
        return "admin/login/modifyPassWord";
    }

    @RequestMapping("/modifyPassWord")
    public String modifyPassWord(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord
                                 ,@RequestParam("newPassWord") String newPassWord) throws UnsupportedEncodingException {

        User user = userServiceImpl.queryByUserName(userName);
        if(user.getPassWord().equals(passWord)){
            //修正新的密码
            user.setPassWord(newPassWord);
            userServiceImpl.updateUser(user);

            return "redirect:/login/home";
        }

        String error = "旧密码输入错误";
        return "redirect:/toModifyPassWord?error="+URLEncoder.encode(error,"utf-8");
    }


    @RequestMapping("/toDeleteUser")
    public String toDeleteUser(@Nullable @RequestParam("error") String error,Model model){

        if(error != null){
            model.addAttribute("error",error);
        }
        return "admin/login/deleteUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request,@RequestParam("passWord") String passWord) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        String userName = (String)session.getAttribute("loginUser");
        User user = userServiceImpl.queryByUserName(userName);

        if(user.getPassWord().equals(passWord)){
            userServiceImpl.deleteUser(userName);
            return "redirect:/toLogin";
        }

        String error = "密码输入错误,删除失败";

        return "redirect:/toDeleteUser?error="+URLEncoder.encode(error,"utf-8");
    }

/*    @RequestMapping("/left")
    public String left() {

        return "admin/login/left";
    }*/

}
