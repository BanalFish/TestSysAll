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
        UsernamePasswordToken usernamePasswordToken= new UsernamePasswordToken(username, password);
        Subject subject =SecurityUtils.getSubject();
        User principal =(User) subject.getPrincipal();

        try {
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            e.printStackTrace();
            return new JSONResult(false,"fail");
        }

        User user=new User();
        user.setId(principal.getId());
        user.setDep(principal.getDep());
        user.setName(principal.getName());
        user.setNumber(principal.getNumber());
        user.setPassword(principal.getPassword());
        user.setWho(principal.getWho());

        return new JSONResult(true,"success",user);

    }

}
