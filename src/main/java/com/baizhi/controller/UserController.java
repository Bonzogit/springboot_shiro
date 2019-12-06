package com.baizhi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
@Controller
public class UserController {
    @RequestMapping("login")
    public String login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
            return "index";
        } catch (UnknownAccountException e) {
            System.out.println("账号不存在");
            return "login/login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return "login/login";
        }


    }

    @RequestMapping("exit")
    public String exit() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "/login/login";
    }
}
