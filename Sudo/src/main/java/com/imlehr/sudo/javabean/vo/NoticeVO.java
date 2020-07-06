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
@ApiModel("通知（用户视角）")
public class NoticeVO {

    @ApiModelProperty(value = "通知正文")
    private String context;
    @ApiModelProperty(value = "通知标题")
    private String title;
    @ApiModelProperty(value = "通知封面")
    private String picUrl;
    @ApiModelProperty(value = "通知时间")
    private String time;
    @ApiModelProperty(value = "是否已读")
    private Boolean hasRead;

}
