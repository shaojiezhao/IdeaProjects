package com.jackzhao.demo.functioninterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamTest2
{
    public static void main(String[] args)
    {
        Stream<String> stringStream = Stream.of("aa","bb","cc");
        stringStream.forEach(System.out::println);

        System.out.println("----------------------");

        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        natual.limit(20).forEach(System.out::println);

        System.out.println("------------------------");

        String textPath = "C:\\Users\\sjzhaom\\Desktop\\text\\textbody.txt";
        try(Stream<String> stream = Files.lines(Paths.get(textPath)))
        {
            stream.forEach(System.out::println);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("----------------------------");

        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("The quick brown fox jumps over the lazy dog");
        s.forEach(System.out::println);

    }
}

class NatualSupplier implements Supplier<Integer>
{
    int n;
    @Override
    public Integer get()
    {
        return n++;
    }
}
