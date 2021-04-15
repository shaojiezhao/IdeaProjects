package com.jackzhao.demo.socketprogram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = new ServerSocket(6666); // 监听指定端口
        System.out.println("server is running...");
        while(true)
        {
            Socket sock = ss.accept();
            System.out.println("connected from " + sock.getRemoteSocketAddress());

            ExecutorService executorService = Executors.newCachedThreadPool();

//            ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
//            ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);

//            Runnable t = new Handler(sock);
//            executorService.execute(t);
            executorService.execute(() -> {
                try (InputStream input = sock.getInputStream())
                {
                    try (OutputStream output = sock.getOutputStream())
                    {
                        handle2(input, output);
                    }
                }
                catch (Exception e)
                {
                    try
                    {
                        sock.close();
                    }
                    catch (IOException ioe)
                    {
                    }
                    System.out.println("client disconnected.");
                }
            });
            executorService.shutdown();
//            t.start();
        }
    }
    private static void handle2(InputStream input, OutputStream output) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        writer.write("hello\n");
        writer.flush();
        for (; ; )
        {
            String s = reader.readLine();
            if (s.equals("bye"))
            {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok: " + s + "\n");
            writer.flush();
        }
    }
}



class Handler implements Runnable
{
    Socket sock;

    public Handler(Socket sock)
    {
        this.sock = sock;
    }

    @Override
    public void run()
    {
        try (InputStream input = this.sock.getInputStream())
        {
            try (OutputStream output = this.sock.getOutputStream())
            {
                handle(input, output);
            }
        }
        catch (Exception e)
        {
            try
            {
                this.sock.close();
            }
            catch (IOException ioe)
            {
            }
            System.out.println("client disconnected.");
        }
    }

    private static void handle(InputStream input, OutputStream output) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        writer.write("hello\n");
        writer.flush();
        for (; ; )
        {
            String s = reader.readLine();
            if (s.equals("bye"))
            {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok: " + s + "\n");
            writer.flush();
        }
    }
}