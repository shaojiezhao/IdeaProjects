package com.jackzhao.demo.functioninterface;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Stream3
{

    public static void main(String[] args) {
        Stream<BigInteger> stream = Stream.generate(new FibonacciQueue());
        stream.limit(50).forEach(System.out::println);
    }
}

class FibonacciQueue implements Supplier<BigInteger>
{

    static Queue<BigInteger> queue = new LinkedList<>();

    static {
        queue.add(new BigInteger("0"));
        queue.add(new BigInteger("1"));
    }

    @Override
    public BigInteger get() {
        BigInteger prev = queue.poll();
        queue.add(prev.add(queue.peek()));
        return queue.peek();
    }
}
