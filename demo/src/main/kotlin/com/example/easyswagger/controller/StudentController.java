package com.example.easyswagger.controller;

import com.example.easyswagger.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "学生接口")
@RestController
@RequestMapping("web/v1/student")
public class StudentController {

    @ApiOperation("根据编号获取学生信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "stu_no", value = "学生编号"))
    @GetMapping("getByNo")
    public StudentVO getByNO(@RequestParam("stu_no") String stuNo) {
        StudentVO stu = new StudentVO();
        stu.setStuNo(stuNo);
        stu.setName("张三");
        return stu;
    }

    @ApiOperation("添加学生信息")
    @ApiImplicitParams(
        {
            @ApiImplicitParam(name = "name", value = "学生名称", defaultValue = "张三"),
            @ApiImplicitParam(name = "no", value = "学生编号", defaultValue = "std-10001", required = true)
        }
    )
    @PostMapping("add")
    public StudentVO addStudent(String name, String no) {
        StudentVO s = new StudentVO();
        s.setName(name);
        s.setStuNo(no);
        return s;
    }
}
