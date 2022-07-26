package cn.code.testsys.web.interceptor;

import org.apache.shiro.subject.Subject;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import org.apache.shiro.SecurityUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url=request.getRequestURI();
        //断点看到swagger的请求中地址包含这些关键字
        if(url.indexOf("swagger")!=-1||url.indexOf("api-docs")!=-1){
            return true;
        }


        if(handler instanceof HandlerMethod){
            Subject subject = SecurityUtils.getSubject();
            if(!subject.isAuthenticated()){
                response.sendRedirect("/login.html");
                return false;
            }
        }
        return true;
    }
}
