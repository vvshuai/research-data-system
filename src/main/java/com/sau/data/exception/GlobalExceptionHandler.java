package com.sau.data.exception;

import com.sau.data.constant.CommonEnum;
import com.sau.data.response.CommonReturnType;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

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
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    @ResponseBody
    public CommonReturnType exceptionHandler(HttpServletRequest req, MaxUploadSizeExceededException e){

        return CommonReturnType.error("-1", "文件过大!");
    }

}
