package cn.code.testsys.web.controller;

import cn.code.testsys.domain.Course;
import cn.code.testsys.qo.CourseQueryObject;
import cn.code.testsys.qo.PageResult;
import cn.code.testsys.service.ITeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Clock;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherCourseController {

    @Autowired
    private ITeacherCourseService teacherCourseService;

    @RequestMapping("/course/listPage")
    public ModelAndView listCourPage(CourseQueryObject queryObject){
        ModelAndView mv=new ModelAndView();
        PageResult<Course> pageResult=teacherCourseService.selectCoursePage(queryObject);
        mv.addObject("pageResult",pageResult);
        mv.setViewName("/teacher/course/list");
        return mv;
    }

    @RequestMapping("/course/list")
    public ModelAndView courList(){
        ModelAndView mv=new ModelAndView();
        List<Course> courses = teacherCourseService.selectCour();
        mv.addObject("courses",courses);
        mv.setViewName("/teacher/course/list");
        return mv;
    }

    @RequestMapping("/course/input")
    public ModelAndView courInput(Long id){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/teacher/course/input");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Course course) {
        //执行保存操作
        teacherCourseService.save(course);
        return "redirect:/department/listPage";
    }

    @RequestMapping("/course/delete")
    public String courDel(Long id){
        teacherCourseService.delete(id);
        return "redirect:/teacher/listPage";
    }
}
