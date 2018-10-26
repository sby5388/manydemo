package com.by5388.xw.android.jnidemo.tools;

import java.util.List;

/**
 * @author by5388  on 2018/10/22.
 */
public interface ArrayToolsApi {
    /**
     * 数组排序
     */
    int[] sortIntegerArray(int[] numbers);

    /**
     * 集合排序
     */
    int[] sortIntegerArray(List<Integer> numbers);
}
