package com.by5388.xw.android.jnidemo.tools;

import java.util.List;


/**
 * @author by5388  on 2018/10/22.
 */
public class ArrayTools implements ArrayToolsApi {
    static {
        System.loadLibrary(LibPath.LIB_PATH);
    }

    @Override
    public int[] sortIntegerArray(int[] numbers) {
        return sortIntegerArrayByJni(numbers);
    }

    @Override
    public int[] sortIntegerArray(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new int[0];
        }

        int[] number2 = new int[numbers.size()];
        for (int i = 0; i < number2.length; i++) {
            number2[i] = numbers.get(i);
        }
        return sortIntegerArray(number2);
    }


    /**
     * 对整形数组进行排序
     *
     * @param numbers 数组
     * @return 排序结果
     */
    private static native int[] sortIntegerArrayByJni(int[] numbers);

}
