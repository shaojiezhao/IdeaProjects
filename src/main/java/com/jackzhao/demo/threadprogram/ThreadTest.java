package com.jackzhao.demo.threadprogram;

public class ThreadTest
{

    public static void main(String[] args)
    {
        Mythread mythread = new Mythread();
        //如下两行代码操作的是两个不同的Mythread对象，两个线程各操作各的对象，所以不会有线程安全问题
//        Thread thread = new Thread(new Mythread());
//        Thread thread2 = new Thread(new Mythread());
        //如下四行代码，四个线程操作的是同一个对象，而且mythread对象里的id变量是全局变量所以这种情况就会出现线程安全问题。
        //mythread对象里的id变量如果是局部变量的话就不会有线程安全问题，因为局部变量必须要初始化，每个线程去操作的时候都会初始化一次这个局部变量
        Thread thread = new Thread(mythread);
        Thread thread2 = new Thread(mythread);
        Thread thread3 = new Thread(mythread);
        Thread thread4 = new Thread(mythread);

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class Mythread implements Runnable
{
    int id = 0;

    @Override
    public void run()
    {
        synchronized (this)
        {
            for (int i = 0; i < 10000; i++)
            {
                id++;
            }
            System.out.println(Thread.currentThread().getName() + "--结果是：" + id);
        }
    }
}

