package com.easydev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login (
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            Map<String , Object> map,
            HttpSession session) {
        if (StringUtils.isEmpty(account) || !"123456".equals(password)) {
            map.put("msg" , "用户名或密码错误");
            return "index";
        }
        session.setAttribute("loginuser" , account);
        return "redirect:/main.html";
    }
}
