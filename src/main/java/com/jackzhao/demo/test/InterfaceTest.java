package com.jackzhao.demo.test;

public interface InterfaceTest
{
    public static final String a = "aaa";

    public abstract void method();

    //default方法，实现类不需要强制实现
    public default Integer method2()
    {
        System.out.println(a);
        return 222;
    }

    public default void method3()
    {

    }

}
