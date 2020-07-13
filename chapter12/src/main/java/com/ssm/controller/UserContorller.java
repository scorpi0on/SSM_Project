package com.ssm.controller;

import com.ssm.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ssm.po.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserContorller {
    @RequestMapping(value = "/selectUser")
    public String selectUser(@RequestParam(value = "user_id") Integer id){
//        String id=request.getParameter("id");
        System.out.println("id="+id);
        return "success";
    }
    @RequestMapping(value = "toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/registerUser")
    public String registerUser(User user){
        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println("username="+username);
        System.out.println("password="+password);
        return "success";
    }

    @RequestMapping(value = "/toUserEdit")
    public String toUserEdit(){
        return "user_edit";
    }

    @RequestMapping(value = "/editUsers")
    public String editUsers(UserVo userList){
        List<User> users = userList.getUsers();
        for (User user :users){
            if (user.getId() != null){
                System.out.println("The id=" + user.getId() + " and name="  + user.getUsername() + " has been deleted");
            }
        }
        return "success";
    }
}
