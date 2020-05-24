package com.imlehr.sudo.controller;


import com.imlehr.security.JwtUtils;
import com.imlehr.sudo.service.TestService;
import com.imlehr.utils.AuthUtils;
import com.imlehr.utils.HeaderUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lehr
 * @create: 2020-04-10
 *
 */
@RestController
@RequestMapping("test")
@Api(tags = "测试接口")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "登录", notes = "得到jwt")
    @GetMapping("/login")
    public String login(String username, String password) {
        AuthUtils.login(username,password);
        //准备jwt去
        String jwtToken = JwtUtils.createToken("123");
        System.out.println(jwtToken);
        return jwtToken;
    }

    @ApiOperation(value = "登出", notes = "退出")
    @GetMapping("/logout")
    @RequiresGuest
    public String logout() {
        return "well done!";
    }

    @ApiOperation(value = "自由访问", notes = "")
    @GetMapping("/a")
    public Integer listRepos() {
        return testService.getNum();
    }

    @ApiOperation(value = "登录访问", notes = "获取你的id")
    @GetMapping("/b")
    @RequiresAuthentication
    public String listRepos2(HttpServletRequest request) {
        return HeaderUtils.getVisitorId(request);
    }

}
