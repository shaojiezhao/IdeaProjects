package com.jackzhao.demo.functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOtherOperationTest
{
    public static void main(String[] args)
    {
        //sort
        List<String> list = Arrays.asList("Orange", "Banana", "apple");
        List<String> sortedList = list.stream().sorted(((o1, o2) -> o2.compareTo(o1))).collect(Collectors.toList());
        System.out.println(sortedList);
        //remove duplicate data
        List<String> duplicateList = Arrays.asList("A", "b", "C", "A", "D");
        System.out.println(duplicateList.stream().distinct().collect(Collectors.toList()));
        //substring
        List<String> substringList = Arrays.asList("Aa", "b", "C", "d", "e", "f", "g", "h");
        System.out.println(substringList.stream().skip(2).limit(3).collect(Collectors.toList()));

        boolean b = substringList.stream().allMatch(item -> item.length() <= 1);
        System.out.println(b);

        //所谓flatMap，就是将每个元素(这些元素本身要是集合)映射为一个stream,然后这些stream再组合成一个新的stream.
        List<List<String>> listList = Arrays.asList(Arrays.asList("1", "2", "3"), Arrays.asList("4", "5", "6"), Arrays.asList("7", "8", "9"));
        System.out.println(listList.stream().flatMap(listItem -> listItem.stream()).collect(Collectors.toList()));


    }
}
