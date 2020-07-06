package com.imlehr.sudo.controller;


import com.google.common.collect.Lists;
import com.imlehr.sudo.javabean.vo.AuthVO;
import com.imlehr.sudo.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lehr
 * @create: 2020-04-10
 *
 */
@RestController
@RequestMapping("auths")
@Api(tags = "信息认证模块")
@Slf4j
public class AuthController {


    @Autowired
    private AuthService authService;

    @RequiresAuthentication
    @ApiOperation(value = "提交认证", notes = "编写认证信息，或者是二次修改认证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名，目前应该就是填写手机号码的意思"),
            @ApiImplicitParam(name = "province", value = "省名"),
            @ApiImplicitParam(name = "city", value = "市名"),
            @ApiImplicitParam(name = "district", value = "区名"),
            @ApiImplicitParam(name = "block", value = "小区"),
            @ApiImplicitParam(name = "houseNo", value = "楼号"),
            @ApiImplicitParam(name = "floor", value = "楼层"),
            @ApiImplicitParam(name = "roomNo", value = "房间号")
    })
    @PostMapping("")
    public void updateAuth(String username, String province, String city, String district,
                         String block, String houseNo, String floor, String roomNo) {
        authService.updateAuth(username,province,city,district,block,houseNo,floor,roomNo);
    }

    @ApiOperation(value = "查看认证", notes = "查看用户个人的认证情况和信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名，目前应该就是填写手机号码的意思"),
    })
    @GetMapping("/users/{username}")
    public AuthVO getAuthByUsername(@PathVariable("username") String username) {
        return authService.getByUsername(username);
    }


    @ApiOperation(value = "所有认证", notes = "查看目前正在排队审核的认证，这里我先给的是正在等待审核的，而不是所有的或者通过的,这里目前的需求有点模糊，所以设计的不是太好")
    @GetMapping("")
    public List<AuthVO> listAuth() {
        return Lists.newArrayList(new AuthVO().setProvince("四川").setCity("成都").setBlock("沙河小区").setHouseNo("1").setFloor("18").setRoomNo("1802").setState("待审核").setUsername("1388225188"),
        new AuthVO().setProvince("四川").setCity("郫县").setBlock("沙河大区").setHouseNo("1").setFloor("17").setRoomNo("1702").setState("待审核").setUsername("1388225159"),
        new AuthVO().setProvince("四川").setCity("自贡").setBlock("沙河小区").setHouseNo("2").setFloor("16").setRoomNo("1602").setState("待审核").setUsername("1388956159"));
    }


    @ApiOperation(value = "审核认证", notes = "审批用户的认证信息申请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authId", value = "认证的编号"),
            @ApiImplicitParam(name = "pass", value = "是否通过,true是审批通过，false则是驳回")
    })
    @PutMapping("/{authId}")
    public void checkAuth(String authId,Boolean pass) {

    }






}
