### How to use
maven
``` xml
<dependency>
  <groupId>io.github.iamyours</groupId>
  <artifactId>easyswagger</artifactId>
  <version>0.0.2</version>
</dependency>
```
- add `@EnableEasySwagger` below `@EnableSwagger2`
- replace annotation with normal doc info

### Example
#### Controller
replace annotation
``` java
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
```
to
``` java
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
```
#### for model
replace
``` java
@ApiModel("学生实体")
public class StudentVO {
    @ApiModelProperty("学生姓名")
    private String name;
    @ApiModelProperty("学生编号")
    private String stuNo;

    //setter and getter
}
```
to
``` java
/**
 * 学生实体
 */
public class StudentVO {
    private String name;    //学生姓名
    private String stuNo;   //学生编号

    //setter and getter
}
```



