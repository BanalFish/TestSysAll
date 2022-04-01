package cn.code.testsys.web.controller;

import cn.code.testsys.domain.User;
import cn.code.testsys.qo.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="用户登录")
public class LoginController {

    @PostMapping("/userLogin")
    @ApiOperation(value="用户登录")
    public JSONResult userlogin(@RequestParam("username")String username, @RequestParam("password") String password){

        int who=0;//返回登录用户的身份状态

        try {
            UsernamePasswordToken usernamePasswordToken= new UsernamePasswordToken(username, password);
            Subject subject =SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            User principal =(User) subject.getPrincipal();
            who= principal.getWho();
        }catch (AuthenticationException e){
            e.printStackTrace();
            return new JSONResult(false,"fail");
        }

        return new JSONResult(true,"success",who);

    }

}
