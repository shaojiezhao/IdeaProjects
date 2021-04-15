package com.jackzhao.demo.functioninterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ReduceTest
{
    public static void main(String[] args)
    {
        //如下参数0是给totalSum的初始化值
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (totalSum, item) -> totalSum + item);
        System.out.println(sum); // 45

        System.out.println("-----------------------------");

        String prop = "profile=native";
        Arrays.stream(prop.split("\\=",2)).forEach(System.out::println);


//         按行读取配置文件:
//        List<String> props = Arrays.asList("profile=native", "debug=true", "logging=warn", "interval=500");
//        Map<String, String> map = props.stream()
//                // 把k=v转换为Map[k]=v:
//                .map(kv -> {
//                    String[] ss = kv.split("\\=", 2);
////                    return Map.of(ss[0], ss[1]);
//                    return ;
//                })
//                // 把所有Map聚合到一个Map:
//                .reduce(new HashMap<String, String>(), (m, kv) -> {
//                    m.putAll(kv);
//                    return m;
//                });
//        // 打印结果:
//        map.forEach((k, v) -> {
//            System.out.println(k + " = " + v);
//        });
    }
}
