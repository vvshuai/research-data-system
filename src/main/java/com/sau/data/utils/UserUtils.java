package com.sau.data.utils;

import com.sau.data.entity.UserDO;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 13:21 2020/12/20
 * @Modified By:
 */
public class UserUtils {

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 获取request
     */
    public static HttpServletRequest getRequest()
    {
        return getRequestAttributes().getRequest();
    }

    public static UserDO getUserDO(){
        HttpServletRequest request = getRequest();
        UserDO userDO = (UserDO) request.getSession().getAttribute("user");
        return userDO;
    }
}
