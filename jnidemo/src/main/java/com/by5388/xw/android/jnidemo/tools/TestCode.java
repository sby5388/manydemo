package com.by5388.xw.android.jnidemo.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by5388  on 2018/10/18.
 */
public class TestCode {
    public void test() {
        Tools.getMiALong(5);
        int result = Tools.getSum(3, 4);
        System.out.println(result);
        Tools tools = new Tools();
        tools.setPersonName("212");
        System.out.println(tools.getString());
        int[] numbers = {1, 2, 3};
        System.out.println(Arrays.toString(numbers));
        NumberTools.sortNumber(numbers);
        NumberTools.show("by5388");
        System.out.println(Arrays.toString(numbers));
    }


    public void testArrays() {
        int[] numbers = {5, 2, 3, 7};
        ArrayToolsApi api = new ArrayTools();
        System.out.println(Arrays.toString(api.sortIntegerArray(numbers)));

        List<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(10);
        integers.add(8);
        integers.add(40);
        System.out.println(Arrays.toString(api.sortIntegerArray(integers)));
    }
}
