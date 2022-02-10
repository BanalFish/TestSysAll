package cn.code.testsys.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class LoginController {

    @RequestMapping("/list")
    public String index(){
        ModelAndView mv=new ModelAndView();
        return "/teacher/list";
    }
}
