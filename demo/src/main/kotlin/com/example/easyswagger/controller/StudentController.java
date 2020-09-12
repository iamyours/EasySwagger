package com.example.easyswagger.controller;

import com.example.easyswagger.vo.StudentVO;
import org.springframework.web.bind.annotation.*;

/**
 * 学生接口
 */
@RestController
@RequestMapping("web/v1/student")
public class StudentController {
    /**
     * 根据编号获取学生信息
     * @param stuNo 学生编号
     */
    @GetMapping("getByNo")
    public StudentVO getByNO(@RequestParam("stu_no") String stuNo) {
        StudentVO stu = new StudentVO();
        stu.setStuNo(stuNo);
        stu.setName("张三");
        return stu;
    }

    /**
     * 添加学生信息
     * @param name 学生名称|张三
     * @param no   学生编号|required|std-10001
     */
    @PostMapping("add")
    public StudentVO addStudent(String name, String no) {
        StudentVO s = new StudentVO();
        s.setName(name);
        s.setStuNo(no);
        return s;
    }
}
