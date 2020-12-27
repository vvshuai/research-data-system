package com.sau.data.aspect;

import com.sau.data.constant.UserTypeEnum;
import com.sau.data.entity.UserDO;
import com.sau.data.utils.UserUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 16:17 2020/12/27
 * @Modified By:
 */
@Aspect
@Component
@Order(1)
public class PermissionAdvice {

    @Pointcut("@annotation(com.sau.data.annotation.DeletePermissionsAnnotation)")
    private void permissionDeleteCheck() {
    }

    @Around("permissionDeleteCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable{

        return joinPoint.proceed();
    }
}
