package com.jackzhao.demo.collectionprogram;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1,2,3);
        Integer[] arr = list.toArray(new Integer[list.size()]);
//        Integer[] arr = list.toArray(Integer[]::new);
        for (Integer i : arr)
        {
            System.out.println(i);
        }

    }
}
