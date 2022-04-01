package cn.code.testsys.web.controller.teacher;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    //统计分析
    @RequestMapping("/analysis/list")
    public String anaList(){
        ModelAndView mv=new ModelAndView();
        return "teacher/analysis/list";
    }

}
