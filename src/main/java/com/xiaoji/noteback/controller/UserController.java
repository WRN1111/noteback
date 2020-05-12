package com.xiaoji.noteback.controller;


import com.xiaoji.noteback.pojo.User;
import com.xiaoji.noteback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("api/register")
    @ResponseBody
    public Integer Register(){
        User user = userService.getUserByUsername("leo");
        return user.getId();
    }
}
