package com.sau.data.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 13:48 2020/12/12
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String errorCode;

    private String errorMsg;

}
