package com.sau.data.config;

import com.sau.data.entity.StudentDO;
import com.sau.data.entity.TeacherDO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 16:07 2020/12/12
 * @Modified By:
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        StudentDO studentDO = (StudentDO) request.getSession().getAttribute("student");
        TeacherDO teacherDO = (TeacherDO) request.getSession().getAttribute("teacher");

        if(studentDO == null && teacherDO == null) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
