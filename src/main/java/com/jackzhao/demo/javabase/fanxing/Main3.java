package com.jackzhao.demo.javabase.fanxing;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main3
{
    public static void main(String[] args)
    {
        String[] arr = asArray("one", "two", "three");
        System.out.println(Arrays.toString(arr));
        // ClassCastException:
        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));
    }

    static <K> K[] pickTwo(K k1, K k2, K k3)
    {
        System.out.println(k1 + "," + k2);
        //k1,k2在这里是K类型，要把k1和k2传到asArray方法，编译器无法确定它到底属于什么类型，因此编译器会将它擦拭成Object类型，然后传下去
        return asArray(k1, k2);
    }

    static <T> T[] asArray(T... objs)
    {
        System.out.println("objs:" + objs);
        return objs;
    }
}
