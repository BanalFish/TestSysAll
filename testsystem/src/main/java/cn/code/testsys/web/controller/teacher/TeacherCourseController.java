package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.Course;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.ITeacherCourseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//教师课程管理
//@CrossOrigin
@RestController
@RequestMapping("/teacher")
@Api(tags="教师课程管理")
public class TeacherCourseController {

    @Autowired
    private ITeacherCourseService teacherCourseService;


    @GetMapping("/courList")
    @ApiOperation(value="根据教师id查询课程")
    public Result<Course> courListTest(@ApiParam("教师id") @RequestParam("tId") Long tId){
        List<Course> courses = teacherCourseService.selectByUser(tId);
        return new Result().setCode(200).setData(courses).setMessage("查询成功");
    }

    @PostMapping("/course/add")
    @ApiOperation(value = "教师添加课程")
    @ApiImplicitParam(name = "tId",value="教师id",required = true,dataType = "Long",paramType ="path")
    public Result<Course> courInput(@RequestBody Course course,@RequestParam("tId") Long tId){
        teacherCourseService.addCourse(course,tId);
        List<Course> courses = teacherCourseService.selectByUser(tId);
        return new Result().setCode(200).setData(courses).setMessage("添加成功");
    }



    @ApiOperation(value="教师根据id删除课程")
    @DeleteMapping(value = "/course/delete")
    public Result courDel(@RequestParam("tId")Long tId,@RequestParam("cId")Long cId){
        teacherCourseService.delete(cId,tId);
        return new Result().setCode(200).setMessage("删除成功");
    }

    @ApiOperation(value="教师通过学生Id将其添加到某课程或者学生主动加入课程")
    @DeleteMapping(value = "/course/join")
    public Result addStu2Cour(@RequestParam("stuIds")Long[] stuIds,@RequestParam("cId")Long cId){
        teacherCourseService.addStu2Cour(stuIds,cId);
        return new Result().setCode(200).setMessage("加入课程成功");
    }


}
