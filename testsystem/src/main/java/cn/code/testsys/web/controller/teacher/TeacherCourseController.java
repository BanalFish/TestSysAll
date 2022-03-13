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
@Controller
@RequestMapping("/teacher")
@Api(tags="教师课程管理")
public class TeacherCourseController {

    @Autowired
    private ITeacherCourseService teacherCourseService;

    //分页功能
//    @RequestMapping("/course/listPage")
//    public ModelAndView listCourPage(CourseQueryObject queryObject){
//        ModelAndView mv=new ModelAndView();
//        PageResult<Course> pageResult=teacherCourseService.selectCoursePage(queryObject);
//        mv.addObject("pageResult",pageResult);
//        mv.setViewName("/teacher/course/list");
//        return mv;
//    }

//    @ApiOperation(value="根据教师id查询课程")
//    @ApiImplicitParam(name = "tId",value="教师id",required = true,dataType = "Long")
//    @RequestMapping(value = "/courList/{tId}",method = RequestMethod.GET)
//    public Result courList(@PathVariable("tId") Long tId){
//        List<Course> courses = teacherCourseService.selectByUser(tId);
//
//        return new Result().setCode(200).setData(courses).setMessage("查询成功");
//    }

    @GetMapping("/courList/{tId}")
    @ApiOperation(value="根据教师id查询课程")
    @ApiImplicitParam(name = "tId",value="教师id",required = true,dataType = "Long",paramType ="path")
    @ApiResponses(value={
            @ApiResponse(code=200,message = "成功"),
            @ApiResponse(code=202,message = "缺少参数")
    })
    public Result<Course> courListTest(@ApiParam("教师id") @PathVariable("tId") Long tId){
        List<Course> courses = teacherCourseService.selectByUser(tId);

        return new Result().setCode(200).setData(courses).setMessage("查询成功");
    }



    @ApiOperation(value = "教师添加课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course",value = "课程详细实体course",required = true,dataType = "Course"),
            @ApiImplicitParam(name = "tId",value="教师id",required = true,dataType = "Long")
    })
    @RequestMapping(value="/course/add/{tId}", method=RequestMethod.POST)
    public String courInput(Course course,@PathVariable("tId") Long tId){
        teacherCourseService.addCourse(course,tId);

        return "success";
    }

    @ApiOperation(value="教师根据id删除课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cId",value = "课程id",required = true,dataType = "Long"),
            @ApiImplicitParam(name = "tId",value="教师id",required = true,dataType = "Long")
    })
    @RequestMapping(value = "/course/delete/{tId}",method=RequestMethod.DELETE)
    public String courDel(Long cId,Long tId){
        teacherCourseService.delete(cId,tId);

        return "success";
    }

}
