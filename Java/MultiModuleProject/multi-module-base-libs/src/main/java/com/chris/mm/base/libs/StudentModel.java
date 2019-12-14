package com.chris.mm.base.libs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chrischan
 * create on 2019\7\17 0017 15:20
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "StudentModel", description = "学生")
public class StudentModel extends UserModel {
    @ApiModelProperty(value = "学校", example = "清河中学")
    private String school;
    @ApiModelProperty(value = "总成绩", example = "588")
    private int score;

    public StudentModel(String name, int age, String school, int score) {
        super(name, age);
        this.school = school;
        this.score = score;
    }
}
