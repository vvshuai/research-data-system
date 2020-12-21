package com.sau.data.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: vvshuai
 * @Description:
 * @Date: Created in 21:31 2020/12/20
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageHelper<T> {

    // 实体集合
    private List<T> rows = new ArrayList<T>();

    // 总数
    private int total;
}
