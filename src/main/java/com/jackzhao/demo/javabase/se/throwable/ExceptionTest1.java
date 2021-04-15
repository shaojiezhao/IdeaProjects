package com.jackzhao.demo.javabase.se.throwable;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

//@Retention(R)
public class ExceptionTest1
{
    public static void main(String[] args)
    {
        try
        {
            Integer.parseInt("abc");
        }
        catch (Exception e)
        {
            System.out.println("catched");
            throw new RuntimeException(e);
        }
        finally
        {
            System.out.println("finally");
        }

    }
}
