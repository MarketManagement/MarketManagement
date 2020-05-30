package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")

    public String login(@RequestParam("Loginname") String Loginname,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) //model用于回显数据
    {
        if(!StringUtils.isEmpty(Loginname) && "123456".equals(password))
        {   session.setAttribute("loginUser",Loginname);
            return "redirect:/main";} //重定向至dashboard
        else
        {
            model.addAttribute("msg","密码或用户名错误！");
            return  "index";
        }
    }
    @RequestMapping("/user/logout")
    public  String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index.html";
    }

}
