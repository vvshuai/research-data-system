package com.sau.data.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 21:29 2020/12/20
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    // 每页显示数量
    private int limit;

    // 页码
    private int page;

    // sql语句起始索引
    private int offset;
}
