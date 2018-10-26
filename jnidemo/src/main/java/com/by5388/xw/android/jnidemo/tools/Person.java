package com.by5388.xw.android.jnidemo.tools;

/**
 * @author by5388  on 2018/10/16.
 */
public class Person {
    private String name = "null";

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
