package com.vah.let.thread;

import java.lang.ref.WeakReference;

/**
 * @Description
 * @Author Jiang
 * @Date 2021/10/14 4:07 下午
 **/
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<ThreadLocal> t = new WeakReference<>(new ThreadLocal<String>());
        ThreadLocal t2 = new ThreadLocal<String>();
        Thread a = new Thread(() -> {

            t.get().set(new long[Integer.MAX_VALUE]);

            t2.set("at2");
            //System.gc();
            System.out.println("a线程get():" + t.get().get());
            System.out.println("a线程t2get():" + t2.get());
        }, "a");
        Thread b = new Thread(() -> {
            t.get().set("b");
            System.out.println("b线程get():" + t.get().get());
        }, "b");

        a.start();
        b.start();
        Thread.sleep(5000);
        System.out.println(0x61c88647);

    }
}

