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
public class CommonReturnType {

    private String code;
    private String message;
    private Object data;

    public CommonReturnType(String code, String message){
        this.code = code;
        this.message = message;
    }

    public static CommonReturnType success(Object data) {
        CommonReturnType commonReturnType = new CommonReturnType();

        commonReturnType.setCode("200");
        commonReturnType.setMessage("成功");
        commonReturnType.setData(data);

        return commonReturnType;
    }

    public static CommonReturnType error(String code, String message) {
        CommonReturnType commonReturnType = new CommonReturnType();

        commonReturnType.setCode(code);
        commonReturnType.setMessage(message);

        return commonReturnType;
    }
}
