package com.jackzhao.demo.springprogram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Value("${girl.name}")
    private String girlName;

    @GetMapping("/hello")
    public String helloGirl()
    {
        return girlName;
    }
}
