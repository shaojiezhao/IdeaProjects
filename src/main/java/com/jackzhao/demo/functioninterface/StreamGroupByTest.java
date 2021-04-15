package com.jackzhao.demo.functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupByTest
{
    public static void main(String[] args)
    {
        Student student1 = new Student(1, 1, "jack", 100);
        Student student2 = new Student(1, 1, "bob", 100);
        Student student3 = new Student(2, 1, "rose", 100);
        Student student4 = new Student(2, 1, "sally", 100);
        Student student5 = new Student(3, 1, "zero", 100);
        Student student6 = new Student(4, 1, "one", 100);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6);
        Map<Integer, List<Student>> groupResultMap = students.stream().collect(Collectors.groupingBy
                (item -> item.gradeId, Collectors.toList()));
        groupResultMap.forEach((k, v) -> System.out.println
                (k + " = " + v.stream().map(student -> student.name).collect(Collectors.toList())));

    }
}

class Student
{
    int gradeId;
    int classId;
    String name;
    int score;

    public Student(int gradeId, int classId, String name, int score)
    {
        this.gradeId = gradeId;
        this.classId = classId;
        this.name = name;
        this.score = score;
    }
}
