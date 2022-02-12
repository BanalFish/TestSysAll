package cn.code.testsys.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @RequestMapping("/analysis/list")
    public String anaList(){
        ModelAndView mv=new ModelAndView();
        return "teacher/analysis/list";
    }


    @RequestMapping("/questions/list")
    public String quesList(){
        ModelAndView mv=new ModelAndView();
        return "teacher/questions/list";
    }

    @RequestMapping("/testpaper/list")
    public String paperList(){
        ModelAndView mv=new ModelAndView();
        return "teacher/testpaper/list";
    }
}
