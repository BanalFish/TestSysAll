package cn.code.testsys.realm;

import cn.code.testsys.domain.User;
import cn.code.testsys.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        User user=iUserService.getByNameAndPass(token.getUsername(), String.valueOf(token.getPassword()));

        if(user==null){
            return null;
        }
        else{
            return new SimpleAuthenticationInfo(
                    user,
                    user.getPassword(),
                    user.getName()
            );
        }
    }

    //授权
    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        User user =(User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        List<String> perms=new LinkedList<>();

        //管理员
        if(user.getWho()==0){
            info.addRole("admin");
            perms.add("模拟教师/学生登录");
            perms.add("展示所有教师信息");
            perms.add("展示所有学生信息");
            info.addStringPermissions(perms);
        }
        //教师
        else if(user.getWho()==1){
            info.addRole("teacher");
            perms.add("试卷管理");
            perms.add("考试管理");
            perms.add("课程管理");
            perms.add("试题管理");
            perms.add("分析统计");
            info.addStringPermissions(perms);
        }
        //学生
        else if(user.getWho()==2){
            info.addRole("student");
            perms.add("参加课程");
            perms.add("参加考试");
            perms.add("查看成绩");
            info.addStringPermissions(perms);
        }

        return info;
    }
}
