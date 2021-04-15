package com.jackzhao.demo.javabase.fanxing;

/**
 * **
 *  * 不论是class A<? extends T>``还是``class A<? super T>
 *  *
 *  * 之所以能对get和set作出限制，最根本的原因是Java只能向上转型且无法在运行中获取到T到底属于什么类
 *  *
 *  * 对于class A<? extends T>：
 *  *
 *  * 因为传入的必定是Pair<T或者T的子类>，所以调用get方法因为返回的必定是T或者T的子类，这样的话就可以用T进行接收，
 *  * 例如：Number n = p.get()，因为返回的必定是Number的子类，所以可以向上转型成Number接收。但是无法调用set方法，
 *  * 因为无法向下转型且在运行过程中无法获取T到底是什么类型，你想啊你要是set(T)，但实际上**?(实际的类型)又是T的子类**，
 *  * 又无法向下转型，那能怎么办，只能报错呗~所以在编译的时候就不会通过。所以无法调用set
 *  *
 *  * 对于class A<? super T>:
 *  *
 *  * 因为传入的Pair<T或者T的父类>，当调用set方法时，set(T)，不论T到底是什么，最后都可以向上转型到相应的父类。但是当调用get方法时由于
 *  * 不知道返回的T到底是什么类型，其无法向下转型就不能用T接收。所以无法调用get()
 *  */

public class Main2
{
    public static void main(String[] args)
    {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        Integer i = p2.getFirst();
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }

    static void setSame(Pair<? super Integer> p, Integer n)
    {
        //compile error,因为如果p传进来的是Pair<Number>,则无法将Number强制转换为Integer
//        Integer i = p.getFirst();

        p.setFirst(n);
        p.setLast(n);
    }
}
