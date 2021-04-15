package com.jackzhao.demo.functioninterface;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Stream4
{

    public static void main(String[] args)
    {
        Stream<Integer> stream4 = Stream.generate(new FibonacciSupplier());
        stream4.limit(20).forEach(System.out::println);

        System.out.println("--------------------------");

        NormalClass normalClass= new NormalClass();
        Queue<Integer> queue = normalClass.number();
        queue.stream().forEach(System.out::println);
    }

}

class FibonacciSupplier implements Supplier<Integer>
{
    int i = 0;
    int j = 1;

    @Override
    public Integer get()
    {
        int t = i;
        i = i + j;
        j = t;

        return i;
    }
}

class NormalClass
{
    int i = 0;
    int j = 1;

    int n = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    Queue<Integer> number()
    {
        while (n < 20)
        {
            queue.add(j);

            int t = j;
            j = i + j;
            i = t;

            n++;
        }

        return queue;
    }

}
