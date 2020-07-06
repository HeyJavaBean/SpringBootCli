package com.imlehr.sudo.controller;


import com.google.common.collect.Lists;
import com.imlehr.sudo.javabean.vo.AuthVO;
import com.imlehr.sudo.javabean.vo.NoticeDetailVO;
import com.imlehr.sudo.javabean.vo.NoticeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lehr
 * @create: 2020-04-10
 *
 */
@RestController
@RequestMapping("notices")
@Api(tags = "通知推送模块")
@Slf4j
public class NoticeController {

    @ApiOperation(value = "接受通知", notes = "用户查询自己应该收到的通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名，目前应该就是填写手机号码的意思"),
    })
    @GetMapping("/users/{username}")
    public List<NoticeVO> listUserNotice(@PathVariable("username") String username) {
        return Lists.newArrayList(new NoticeVO().setContext("今天下雨").setTitle("天气预报").setHasRead(false).setPicUrl("https://pic.imlehr.com/uploads/typora/lakjasdf.jpg").setTime("2020-07-06"),
                new NoticeVO().setContext("今天打雷").setTitle("天气预报").setHasRead(true).setPicUrl("https://pic.imlehr.com/uploads/typora/lakjasdf.jpg").setTime("2020-07-03"),
                new NoticeVO().setContext("今天收钱").setTitle("社区通知").setHasRead(true).setPicUrl("https://pic.imlehr.com/uploads/typora/lakjasdf.jpg").setTime("2020-07-02"),
                new NoticeVO().setContext("电梯炸了").setTitle("物业通知").setHasRead(true).setPicUrl("https://pic.imlehr.com/uploads/typora/lakjasdf.jpg").setTime("2020-07-01"));
    }

    @ApiOperation(value = "所有通知", notes = "管理员查看自己发布的所有通知")
    @GetMapping("")
    public List<NoticeDetailVO> listAllNotice() {
        return Lists.newArrayList(new NoticeDetailVO().setContext("今天下雨").setTitle("天气预报")
                .setPicUrl("https://pic.imlehr.com/uploads/typora/lakjasdf.jpg").setTime("2020-07-06")
        .setHouseNo(null).setReadNum(20).setRoomNo(null).setFloor(new String[]{"11", "12"}),
                new NoticeDetailVO().setContext("今天收钱").setTitle("物业通知")
                        .setPicUrl("https://pic.imlehr.com/uploads/typora/lakjasdf.jpg").setTime("2020-07-03")
                        .setHouseNo(null).setReadNum(0).setRoomNo(null).setFloor(new String[]{"1802", "1102"}),
                new NoticeDetailVO().setContext("开业打折").setTitle("社区动态")
                        .setPicUrl("https://pic.imlehr.com/uploads/typora/lakjasdf.jpg").setTime("2020-07-01")
                        .setHouseNo(new String[]{"1", "2"}).setReadNum(21).setRoomNo(null).setFloor(null));
    }


    @ApiOperation(value = "发布通知", notes = "管理员发布一条通知")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "通知标题"),
            @ApiImplicitParam(name = "picUrl", value = "通知封面（目前没想好图片怎么做，就先是url吧）"),
            @ApiImplicitParam(name = "context", value = "通知正文"),
            @ApiImplicitParam(name = "houseNo", value = "通知范围：楼号，发过来要是个数组哈"),
            @ApiImplicitParam(name = "floor", value = "通知范围：楼层，发过来要是个数组哈"),
            @ApiImplicitParam(name = "roomNo", value = "通知范围：房号，发过来要是个数组哈"),
    })
    @PostMapping("/{authId}")
    public void postNotice(String title,String picUrl,String context,String houseNo,String floor,String roomNo) {

    }






}
