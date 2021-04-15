package com.jackzhao.demo.functioninterface;

import com.jackzhao.demo.test.InterfaceTest;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionInterfaceClass
{

    public Integer method(int x, int y,  FunctionInterfaceTest<Integer, Integer> functionInterfaceTest)
    {
        return functionInterfaceTest.sum(x, y);
    }

    public static void main(String[] args)
    {
        FunctionInterfaceClass functionInterfaceClass = new FunctionInterfaceClass();
        ImplementionClass implementionClass = new ImplementionClass();
        Integer result = functionInterfaceClass.method(2, 3, (a,b) -> a + b);
        Integer resultWithImplementionClass = functionInterfaceClass.method(2, 3, implementionClass);
        System.out.println(result);
        System.out.println(resultWithImplementionClass);

    }
}
