package com.sau.data.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 10:01 2020/12/20
 * @Modified By:
 */
@AllArgsConstructor
public enum FilePrefixEnum {

    OTHER_FILE_PREFIX("D:\\research-data-file\\other_file\\"),
    CODE_FILE_PREFIX("D:\\research-data-file\\code_file\\"),
    PAPER_FILE_PREFIX("D:\\research-data-file\\paper_file\\"),
    STUDY_FILE_PREFIX("D:\\research-data-file\\study_file\\")
    ;

    private String prefix;

    public String getPrefix(){
        return prefix;
    }
}
