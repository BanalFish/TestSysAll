package cn.code.testsys.web.filter;

import cn.code.testsys.domain.User;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        //获取已登录用户信息
        User user =(User) subject.getPrincipal();
        //获取session
        HttpServletRequest r=(HttpServletRequest)request;
        HttpSession session = r.getSession();

        session.setAttribute("user",user);

        return super.onLoginSuccess(token,subject,request,response);
    }
}
