package com.by5388.xw.android.jnidemo.tools;


import static com.by5388.xw.android.jnidemo.tools.LibPath.LIB_PATH;

/**
 * @author by5388  on 2018/10/17.
 */

public class NumberTools {

    static {
        System.loadLibrary(LIB_PATH);
    }

    public static void sortNumber(int[] integers) {
        sortNumberByJni(integers, integers.length);
    }

    private static native void sortNumberByJni(int[] integers, int length);


    public static void show(String name) {
        showFromJni(name);
    }

    private static native void showFromJni(String name);
}
