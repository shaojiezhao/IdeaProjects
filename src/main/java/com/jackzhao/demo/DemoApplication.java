package com.jackzhao.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;

/**
 * JMX:Java Management Extension,它是一个Java平台的管理和监控接口。JMX把所有管理的资源成为MBean(Managed Bean).
 * 加上@EnableMBeanExport注解就是告诉Spring自动注册MBean
 */
@EnableMBeanExport
@SpringBootApplication
public class DemoApplication
{

    public static void main(String[] args)
    {
        System.out.println("  ");
        SpringApplication.run(DemoApplication.class, args);
    }

}
