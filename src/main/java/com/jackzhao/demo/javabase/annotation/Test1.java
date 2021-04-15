package com.jackzhao.demo.javabase.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.logging.Logger;

public class Test1
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Test1.class);
//    private static final Logger logger = Logger.getGlobal();
    @AnnotationTest1(count = 3)
    public static void test() throws NoSuchMethodException
    {
        AnnotationTest1 anno = Test1.class.getMethod("test").getAnnotation(AnnotationTest1.class);
        int count = anno.count();
        System.out.println(count);
    }

    public static void main(String[] args)
    {
//        logger.info("java logging start process...");
        LOGGER.info("slfj start process...");
        LOGGER.error("sl4j error output!!!, it is {}","hello world");
        try
        {
            test();
        }
        catch (NoSuchMethodException e)
        {
            System.out.println("hello world!!!");
            LOGGER.error("no such method!!!");
//            LOGGER.info("hello world");
//            logger.info("start process...");
            e.printStackTrace();
        }

        List list = new ArrayList();
        list.add("sf");
        list.add(1);
        System.out.println(list.get(0));
    }
}
