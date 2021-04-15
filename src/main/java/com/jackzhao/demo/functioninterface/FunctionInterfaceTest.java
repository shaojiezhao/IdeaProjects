package com.jackzhao.demo.functioninterface;

@FunctionalInterface
public interface FunctionInterfaceTest<T,V>
{
    T sum(T t, V v);
}
