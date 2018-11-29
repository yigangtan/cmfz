package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession httpSession){
        User user=userService.login(username,password);
        if(user!=null){
            httpSession.setAttribute("user", user);
            return "redirect:/main/main.jsp";
        }else{
            return "/login";
        }
    }
}
