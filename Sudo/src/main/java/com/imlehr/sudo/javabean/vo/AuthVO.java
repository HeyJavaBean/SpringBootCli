package com.imlehr.sudo.javabean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Lehr
 * @create: 2020-07-06
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ApiModel("认证信息")
public class AuthVO {

    @ApiModelProperty(value = "用户名(其实是手机号码)")
    private String username;
    @ApiModelProperty(value = "所在省")
    private String province;
    @ApiModelProperty(value = "所在城市")
    private String city;
    @ApiModelProperty(value = "所在小区")
    private String block;
    @ApiModelProperty(value = "所在楼号")
    private String houseNo;
    @ApiModelProperty(value = "所在楼层")
    private String floor;
    @ApiModelProperty(value = "所在房间号")
    private String roomNo;
    @ApiModelProperty(value = "本认证信息的状态：未填写or在审核or审核成功or审核失败")
    private String state;


}
