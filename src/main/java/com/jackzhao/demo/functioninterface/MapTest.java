package com.jackzhao.demo.functioninterface;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MapTest
{
    public static void main(String[] args)
    {
        Arrays.asList(" 2019-12-31 ", "2020 - 01-09 ", "2020- 05 - 01 ", "2022 - 02 - 01", " 2025-01 -01").
                stream().map(String::trim).map(s -> s.replaceAll("\\s*", "")).map(LocalDate::parse).forEach(System.out::println);

        System.out.println("----------------------");

        IntStream.of(1,2,3,4,5,6,7,8,9).filter(x -> x % 2 != 0).forEach(System.out::println);
    }
}
