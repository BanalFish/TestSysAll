package cn.code.testsys.web.controller.teacher;

import cn.code.testsys.domain.Course;
import cn.code.testsys.domain.User;
import cn.code.testsys.qo.CourseQueryObject;
import cn.code.testsys.qo.PageResult;
import cn.code.testsys.qo.Result;
import cn.code.testsys.service.ITeacherCourseService;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Clock;
import java.util.List;

//教师课程管理
@CrossOrigin
@RestController
@RequestMapping("/teacher")
@Api(tags="教师课程管理")
public class TeacherCourseController {

    @Autowired
    private ITeacherCourseService teacherCourseService;


    @GetMapping("/courList/{tId}")
    @ApiOperation(value="根据教师id查询课程")
    @ApiResponses(value={
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=202,message = "缺少参数")
    })
    public Result<Course> courListTest(@ApiParam("教师id") @PathVariable("tId") Long tId){
        List<Course> courses = teacherCourseService.selectByUser(tId);
        return new Result().setCode(200).setData(courses).setMessage("查询成功");
    }


    @PostMapping("/course/add/{tId}")
    @ApiOperation(value = "教师添加课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tId",value="教师id",required = true,dataType = "Long",paramType ="path")
    })
    public Result<Course> courInput(@RequestBody Course course,@PathVariable("tId") Long tId){
        teacherCourseService.addCourse(course,tId);
        List<Course> courses = teacherCourseService.selectByUser(tId);
        return new Result().setCode(200).setData(courses).setMessage("添加成功");
    }



    @ApiOperation(value="教师根据id删除课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cId",value = "课程id",required = true,dataType = "Long",paramType ="path"),
            @ApiImplicitParam(name = "tId",value="教师id",required = true,dataType = "Long",paramType ="path")
    })
    @RequestMapping(value = "/course/delete/{tId}/{cId}",method=RequestMethod.DELETE)
    public String courDel(@PathVariable("tId")Long tId,@PathVariable("cId")Long cId){
        teacherCourseService.delete(cId,tId);
        return "删除成功";
    }

}
