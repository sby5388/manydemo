package com.by5388.xw.android.jnidemo.tools;

/**
 * @author by5388  on 2018/10/26.
 */
public class Tools {
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    private native String stringFromJNI();

    private static native int intGetSumFromJNIAnInt(int a, int b);


    static {
        System.loadLibrary(LibPath.LIB_PATH);
    }

    public String getString() {
        return stringFromJNI();
    }


    public void setPersonName(String name) {
        setPersonNameNative(name);
    }

    private native void setPersonNameNative(String name);


    public static int getSum(int a, int b) {
        return intGetSumFromJNIAnInt(a, b);
    }

    // TODO: 2018/10/16 实现java调用C  /C 调用java


    /**
     * 打印结果
     *
     * @param result 阶乘的结果
     *               getMiALong函数执行后
     *               在c代码中调用
     */
    @SuppressWarnings("unused")
    public static void printResult(int result) {
        System.out.println("结果是：" + result);
    }

    public static String sayHello(String name) {
        return sayHelloFromJni(name);
    }

    /**
     * 阶乘
     *
     * @param number 数字
     * @return 阶乘
     */
    public native static void getMiALong(int number);


    private static native String sayHelloFromJni(String name);
}
