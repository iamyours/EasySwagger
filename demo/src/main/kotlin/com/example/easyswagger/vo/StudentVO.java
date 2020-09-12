package com.example.easyswagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("学生实体")
public class StudentVO {
    @ApiModelProperty("学生姓名")
    private String name;
    @ApiModelProperty("学生编号")
    private String stuNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }
}
