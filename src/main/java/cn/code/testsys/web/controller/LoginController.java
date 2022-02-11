package cn.code.testsys.web.controller;

import cn.code.testsys.domain.User;
import cn.code.testsys.qo.JSONResult;
import cn.code.testsys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public JSONResult userLogin(String username,String password){
        User user = userService.getNameAndPass(username, password);
        if(user != null){
            return new JSONResult(true ,"登陆成功",user);
        }else{
            return new JSONResult(false,"请重新登录");
        }
    }
}
