package com.sau.data.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sau.data.utils.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 22:01 2020/12/26
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeForm extends Page {

    private Integer id;

    private String codeName;

    private String codeDescription;

    private String codeLabel;

    private String userName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
