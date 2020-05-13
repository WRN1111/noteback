package com.xiaoji.noteback.controller;


import com.xiaoji.noteback.pojo.User;
import com.xiaoji.noteback.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("api/register")
    @ResponseBody
    public String Register(@RequestBody User user) {
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        String password = user.getPassword();

        boolean isExist = userService.isExist(username);
        if (isExist) {
            return "用户名已经存在";
        }
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithm = "md5";
        String pwdAfterHash = new SimpleHash(algorithm, password, salt, times).toString();
        user.setSalt(salt);
        user.setPassword(pwdAfterHash);
        userService.addUser(user);
        return "成功";
    }

    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        String username = user.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, user.getPassword());

        try {
            subject.login(usernamePasswordToken);
            return "ok";
        } catch (AuthenticationException e) {
            return "error";
        }
    }
}
