package com.jackzhao.demo.httpprogram;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        URL url = new URL("https://www.sina.com.cn/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        conn.setConnectTimeout(5000); // 请求超时5秒
// 设置HTTP头:
        conn.setRequestProperty("Accept", "*/*");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 11; Windows NT 5.1)");
// 连接并发送HTTP请求:
        conn.connect();
// 判断HTTP响应是否200:
        if (conn.getResponseCode() != 200)
        {
            throw new RuntimeException("bad response");
        }
// 获取所有响应Header:
        Map<String, List<String>> map = conn.getHeaderFields();
        for (String key : map.keySet())
        {
            System.out.println(key + ": " + map.get(key));
        }
// 获取响应内容:
        InputStream input = conn.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        StringBuilder stringBuilder = new StringBuilder();
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine())
        {
//            line = bufferedReader.readLine();
            stringBuilder.append(line).append("\n");
        }
        String textPath = "C:\\Users\\sjzhaom\\Desktop\\text\\textbody.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(textPath)));
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
