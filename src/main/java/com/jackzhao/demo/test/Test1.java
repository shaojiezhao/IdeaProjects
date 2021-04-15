package com.jackzhao.demo.test;

public class Test1 implements InterfaceTest
{
    public static void main(String[] args)
    {
//        System.out.println(InterfaceTest);
        Test1 test1 = new Test1();
        Integer var = test1.method2();
        System.out.println(var);

    }

    @Override
    public void method()
    {

    }
}
