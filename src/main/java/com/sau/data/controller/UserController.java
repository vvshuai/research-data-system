package com.sau.data.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sau.data.entity.UserDO;
import com.sau.data.exception.SystemException;
import com.sau.data.response.CommonReturnType;
import com.sau.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 23:01 2020/12/7
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonReturnType studentLogin(@RequestBody Map<String, Object> map, HttpServletRequest request) throws NoSuchAlgorithmException {

        Long loginNumber = Long.valueOf(String.valueOf(map.get("loginNumber")));
        String password = (String) map.get("password");

        UserDO userDO = userService.selectByNumber(loginNumber, password);

        request.getSession().setAttribute("user", userDO);

        return CommonReturnType.success(null);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public CommonReturnType studentLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");

        return CommonReturnType.success(null);
    }

    @RequestMapping(value = "/getSession", method = RequestMethod.POST)
    public void getSession(HttpServletRequest request, HttpServletResponse response) throws IOException {

        UserDO userDO = (UserDO) request.getSession().getAttribute("user");

        ObjectMapper mapper = new ObjectMapper();
        if(userDO != null) {
            mapper.writeValue(response.getOutputStream(), userDO);
        }
    }

    @PostMapping("/addTag")
    public CommonReturnType addTag(@RequestParam("tagName") String tagName) {

        boolean result = userService.addTag(tagName);
        if(result == false) {
            throw new SystemException("-1", "添加成功");
        }
        return CommonReturnType.success(null);
    }

    @PostMapping("/uploadUsers")
    public CommonReturnType uploadUsers(@RequestParam("file") MultipartFile file) {

        return CommonReturnType.success(null);
    }
}
