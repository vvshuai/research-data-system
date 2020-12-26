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
public enum PrefixEnum {

    OTHER_FILE_PREFIX("D:\\research-data-file\\other_file\\"),
    CODE_FILE_PREFIX("D:\\research-data-file\\code_file\\code\\"),
    CODE_README_FILE_PREFIX("D:\\research-data-file\\code_file\\readme\\"),
    PAPER_FILE_PREFIX("D:\\research-data-file\\paper_file\\paper\\"),
    PAPER_PPT_PREFIX("D:\\research-data-file\\paper_file\\ppt\\"),
    STUDY_FILE_PREFIX("D:\\research-data-file\\study_file\\"),
    REDIS_PREFIX("code_tag_");
    ;

    private String prefix;

    public String getPrefix(){
        return prefix;
    }
}
