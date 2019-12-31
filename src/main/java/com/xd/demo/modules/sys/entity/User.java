package com.xd.demo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.xd.demo.common.enumclass.SexEnum;
import com.xd.demo.common.enumclass.UserStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* <p>
* 用户表
* </p>
* @author xd
* @since 2019-12-19
*/
@Data
@TableName("sys_user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    private String sex;

    private String phone;

    private String email;

    public String getStatus() {
        if (status.equals("1")){
            status = UserStatusEnum.USABLE.getName();
        }else if (status.equals("0")){
            status = UserStatusEnum.UNUSABLE.getName();
        }
        return status;
    }

    public String getSex() {
        if (sex.equals("0")){
            sex = SexEnum.BOY.getName();
        }else if (sex.equals("1")){
            sex = SexEnum.GIRL.getName();
        }else if (sex.equals("2")){
            sex = SexEnum.SECRET.getName();
        }
        return sex;
    }
}