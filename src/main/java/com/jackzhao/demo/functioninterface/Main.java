package com.jackzhao.demo.functioninterface;

import java.util.Arrays;

public class Main
{
    static int sortArr(String s1, String s2)
    {
        return s1.compareTo(s2);
    }

    int sortArr2(String s1, String s2)
    {
        return s1.compareTo(s2);
    }

    public static void main(String[] args)
    {
        String[] arr = {"sdf","3fdd","bnhy","orange"};
        //静态方法引用
//        Arrays.sort(arr, Main::sortArr);
        //实例方法引用
        Arrays.sort(arr, new Main()::sortArr2);
//        Arrays.sort(arr, String::compareTo);
        System.out.println(String.join(",", arr));
    }

}
