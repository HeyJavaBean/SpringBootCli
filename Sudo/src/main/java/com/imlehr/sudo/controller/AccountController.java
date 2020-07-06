package com.imlehr.sudo.controller;


import com.imlehr.security.JwtUtils;
import com.imlehr.sudo.service.AccountService;
import com.imlehr.utils.AuthUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lehr
 * @create: 2020-04-10
 *
 */
@RestController
@RequestMapping("accounts")
@Api(tags = "登录注册模块")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService service;


    @ApiOperation(value = "登录", notes = "得到jwt，进入程序，目前账户名随便写，密码是123456，jwt半小时内有效，目前有一个默认用户：名称sudo密码123456")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名，目前应该就是填写手机号码的意思"),
            @ApiImplicitParam(name = "password", value = "用户注册的时候的密码")
    })
    @PostMapping("/login")
    public String login(String username, String password) {
        AuthUtils.login(username,password);
        //准备jwt去
        String jwtToken = JwtUtils.createToken(username);
        System.out.println(jwtToken);
        return jwtToken;
    }



    @ApiOperation(value = "注册", notes = "注册，进入程序，但是账户处于未验证的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名，目前应该就是填写手机号码的意思"),
            @ApiImplicitParam(name = "password", value = "用户注册的时候的密码"),
            @ApiImplicitParam(name = "code", value = "手机收到的验证码")
    })
    @PostMapping("/register")
    public void register(String username, String password, String code) {
        service.register(username,password);
    }

}
