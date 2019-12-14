package com.chris.mm.base.libs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chrischan
 * create on 2019\7\17 0017 10:47
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserModel", description = "用户")
public class UserModel {
    @ApiModelProperty(value = "姓名", example = "Chris Chan")
    private String name;
    @ApiModelProperty(value = "年龄", example = "42")
    private int age;
}
