package com.sau.data.constant;

import lombok.AllArgsConstructor;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 16:23 2020/12/27
 * @Modified By:
 */
@AllArgsConstructor
public enum UserTypeEnum {
    TEACHER("teacher"),
    STUDENT("student");

    private String userType;

    public String getUserType(){
        return userType;
    }
}
