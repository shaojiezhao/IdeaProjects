package com.jackzhao.demo.functioninterface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest
{
    public static void main(String[] args)
    {
        List<String> nameList = Arrays.asList("bob","jack","rose");

//        List<Person> personList = nameList.stream().map(item -> new Person(item)).collect(Collectors.toList());
        List<Person> personList = nameList.stream().map(Person::new).collect(Collectors.toList());
        personList.stream().forEach(person -> System.out.println(person.name));

    }
}

class Person
{
    String name;

    public Person(String name)
    {
        this.name = name;
    }

}
