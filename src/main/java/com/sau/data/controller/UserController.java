package com.sau.data.controller;

import com.sau.data.response.CommonReturnType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 23:01 2020/12/7
 * @Modified By:
 */
@RestController
public class UserController {

    @RequestMapping(value = "/student_login")
    public CommonReturnType studentLogin() {

        return null;
    }
}
