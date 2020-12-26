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
 * @Date: Created in 20:34 2020/12/23
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudyFileForm extends Page {

    private Integer id;

    private String fileName;

    private String fileType;

    private String userName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
