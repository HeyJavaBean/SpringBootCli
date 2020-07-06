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
@ApiModel("通知（管理员视角）")
public class NoticeDetailVO {

    @ApiModelProperty(value = "通知标题")
    private String title;
    @ApiModelProperty(value = "封面Url")
    private String picUrl;
    @ApiModelProperty(value = "通知正文")
    private String context;
    @ApiModelProperty(value = "已读人数")
    private Integer readNum;
    @ApiModelProperty(value = "发布时间（格式：2020-07-06）")
    private String time;
    @ApiModelProperty(value = "范围：楼号（数组）")
    private String[] houseNo;
    @ApiModelProperty(value = "范围：楼层（数组）")
    private String[] floor;
    @ApiModelProperty(value = "范围：房号（数组）")
    private String[] roomNo;


}
