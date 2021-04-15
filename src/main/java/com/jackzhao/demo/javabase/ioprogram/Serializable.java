package com.jackzhao.demo.javabase.ioprogram;

import java.io.*;
import java.util.Arrays;

public class Serializable
{

    public static void main(String[] args) throws IOException
    {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(buffer))
        {
            outputStream.writeInt(123);
            outputStream.writeUTF("hello");
            outputStream.writeUTF("world");
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer.toByteArray());
        try(ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream))
        {
            int number = inputStream.readInt();
            String s = inputStream.readUTF();
            String s1 = inputStream.readUTF();
            System.out.println(number + "," + s + s1);
        }
    }
}
