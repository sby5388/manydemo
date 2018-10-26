package com.by5388.xw.android.jnidemo.tools;


import static com.by5388.xw.android.jnidemo.tools.LibPath.LIB_PATH;

/**
 * @author by5388  on 2018/10/17.
 */
public class NetTools {
    static {
        System.loadLibrary(LIB_PATH);
    }
    public String getNetIP() {
        return getNetIPFromJni();
    }

    private native String getNetIPFromJni();
}
