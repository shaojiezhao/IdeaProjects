package com.jackzhao.demo.functioninterface;

import java.lang.annotation.Annotation;

public class ImplementionClass implements FunctionInterfaceTest
{
    @Override
    public Object sum(Object o, Object o2)
    {
        Integer i1 = (Integer) o;
        Integer i2 = (Integer) o2;
        return  i1 + i2;
    }
}
