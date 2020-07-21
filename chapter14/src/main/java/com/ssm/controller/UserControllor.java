package com.ssm.controller;

import com.ssm.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserControllor {
    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassowrd();
        if (username != null && username.equals("wujit")){
            if (password != null && "123456".equals(password)){
                session.setAttribute("user_session", user);
                return "redirect:main" ;
            }
        }

        model.addAttribute("msg", "Wrong Username or Password");
        return "login";
    }

    @RequestMapping(value = "/main")
    public String toMain(){
        return "main";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:toLogin";
    }
}
