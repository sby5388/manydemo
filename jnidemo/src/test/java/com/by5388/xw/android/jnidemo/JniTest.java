package com.by5388.xw.android.jnidemo;

import com.by5388.xw.android.jnidemo.tools.TestCode;
import com.by5388.xw.android.jnidemo.tools.Tools;
import org.junit.Test;

/**
 * @author by5388  on 2018/10/18.
 */
public class JniTest {

    /**
     * 测试简单的java<-->C 互相调用：静态方法调用、成员函数调用
     */
    @Test
    public void test() {
        TestCode code = new TestCode();
        code.test();
    }

    /**
     * 测试数组或者容器类的
     */
    @Test
    public void arrayListTest() {
        TestCode code = new TestCode();
        code.testArrays();
    }

    @Test
    public void stringTest() {
        String str = "by5388";
        String result = Tools.sayHello(str);
        System.out.println(result);
    }
}
