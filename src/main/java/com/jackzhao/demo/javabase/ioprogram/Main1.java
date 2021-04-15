package com.jackzhao.demo.javabase.ioprogram;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main1
{
    public static void main(String[] args) throws IOException
    {
        byte[] data = "hello, world!".getBytes("UTF-8");
        byte[] storeArr = new byte[1000];
        try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data)))
        {
            int n;
//            while ((n = input.read()) != -1)
//            {
//                System.out.println((char) n);
//            }

            while (true)
            {
                n = input.read(storeArr, 0, 1000);
                if (-1 == n)
                {
                    break;
                }
            }

            System.out.println("Total read " + input.getBytesRead() + " bytes");
        }

        String[] arr = new String[]{"a","b","c"};
        System.out.println(Arrays.toString(arr));
    }
}

class CountInputStream extends FilterInputStream
{
    private int count = 0;

    CountInputStream(InputStream in)
    {
        super(in);
    }

    public int getBytesRead()
    {
        return this.count;
    }

    public int read() throws IOException
    {
        int n = in.read();
        if (n != -1)
        {
            this.count++;
        }
        return n;
    }

    public int read(byte[] b, int off, int len) throws IOException
    {
        int n = in.read(b, off, len);
        if (n != -1)
        {
            this.count += n;
        }
        return n;
    }
}
