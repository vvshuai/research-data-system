package com.sau.data.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sau.data.entity.StudentDO;
import com.sau.data.exception.SystemException;
import com.sau.data.response.CommonReturnType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 23:01 2020/12/7
 * @Modified By:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/student_login", method = RequestMethod.POST)
    public CommonReturnType studentLogin(@RequestBody Map<String, Object> map, HttpServletRequest request) {

        CommonReturnType commonReturnType = new CommonReturnType();

        String loginNumber = (String) map.get("loginNumber");
        String password = (String) map.get("password");
        StudentDO studentDO = new StudentDO();
        studentDO.setStudentId(1);
        studentDO.setStudentName("vvshuai");
        studentDO.setPassword("123456");

        if(!loginNumber.equals("1")) {
            return commonReturnType.error("300", "用户名或密码不正确");
        }
        request.getSession().setAttribute("student", studentDO);

        System.out.println("test");
        return CommonReturnType.success(studentDO);
    }

    @RequestMapping(value = "/teacher_login")
    public CommonReturnType teacherLogin(@RequestBody Map<String, Object> map) {

        return null;
    }

    @RequestMapping(value = "/getSession")
    public void getSession(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StudentDO user = (StudentDO) request.getSession().getAttribute("student");
        System.out.println(request.getSession().getMaxInactiveInterval());
        if(user != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getOutputStream(), user);
        }
    }
}
