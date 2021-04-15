package com.jackzhao.demo.javabase.fanxing;

class Pair<T>
{
    private T first;
    private T last;

    public Pair(T first, T last)
    {
        this.first = first;
        this.last = last;
        // Compile error:
//        first = new T();
//        last = new T();
//        Object o = new Object();
    }

    public T getFirst()
    {
        return first;
    }

    public void setFirst(T first)
    {
        this.first = first;
    }

    public T getLast()
    {
        return last;
    }

    public void setLast(T last)
    {
        this.last = last;
    }
}
