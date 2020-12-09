package com.sau.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 23:09 2020/12/7
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonReturnType<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonReturnType(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
