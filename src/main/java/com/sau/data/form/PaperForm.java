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
 * @Date: Created in 22:00 2020/12/25
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperForm extends Page {

    private Integer id;

    private String paperName;

    private String pptName;

    private String paperYear;

    private String paperMeeting;

    private String paperWriter;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String userName;
}
