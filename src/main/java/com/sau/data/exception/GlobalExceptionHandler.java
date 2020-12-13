package com.sau.data.exception;

import com.sau.data.constant.CommonEnum;
import com.sau.data.response.CommonReturnType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 13:48 2020/12/12
 * @Modified By:
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public CommonReturnType systemException(HttpServletRequest req, SystemException e) {

        return CommonReturnType.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonReturnType exceptionHandler(HttpServletRequest req, Exception e){

        return CommonReturnType.error("-1", CommonEnum.INTERNAL_SERVER_ERROR.getMessage());
    }
}
