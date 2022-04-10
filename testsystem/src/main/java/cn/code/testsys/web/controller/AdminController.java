package cn.code.testsys.web.controller;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.Question;
import cn.code.testsys.domain.User;
import cn.code.testsys.qo.DoubResult;
import cn.code.testsys.qo.JSONResult;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/getAllCourse")
    @ApiOperation(value="管理员获取全部课程信息")
    public Result coursList(){
        List<Course> courses = adminService.selectCour();
        return new Result().setCode(200).setMessage("查询全部课程成功").setData(courses);
    }

    @GetMapping("/getAllQues")
    @ApiOperation(value="管理员获取所有题目信息")
    public Result<Question>  quesList(){
        List<Question> questions =adminService.selectQues();
        return new  Result().setCode(200).setData(questions).setMessage("查询题库题目成功");
    }

    @GetMapping("/course/search")
    @ApiOperation(value="输入名称模糊查询课程")
    public Result<Course>  searchByName(@RequestParam("name") String name){
        List<Course> courses = adminService.searchByName(name);
        return new Result().setCode(200).setMessage("模糊查询成功").setData(courses);
    }

    @GetMapping("/getAllTeach")
    @ApiOperation(value="管理员获取全部教师信息")
    public Result teachList(){
        List<User> teachs = adminService.getAllTeach();
        return new Result().setCode(200).setMessage("查询全部教师成功").setData(teachs);
    }

    @GetMapping("/getAllStu")
    @ApiOperation(value="管理员获取全部学生信息")
    public Result stuList(){
        List<User> stus = adminService.getAllStu();
        return new Result().setCode(200).setMessage("查询成功").setData(stus);
    }

    /**
     *
     */
    @PostMapping("/simuLogin")
    @ApiOperation(value="管理员模拟登录用户")
    public JSONResult simuLogin(@RequestBody User user){
        String name = user.getName();
        String password = user.getPassword();
        return new LoginController().userlogin(name,password);
    }
}
