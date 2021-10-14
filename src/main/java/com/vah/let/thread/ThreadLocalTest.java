package com.vah.let.thread;

/**
 * @Description
 * @Author Jiang
 * @Date 2021/10/14 4:07 下午
 **/
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal t = new ThreadLocal<String>();
        ThreadLocal t2 = new ThreadLocal<String>();
        Thread a = new Thread(() -> {
            t.set("a");
            t2.set("at2");
            System.out.println("a线程get():" + t.get());
            System.out.println("a线程t2get():" + t2.get());
        }, "a");
        Thread b = new Thread(() -> {
            t.set("b");
            System.out.println("b线程get():" + t.get());
        }, "b");

        a.start();
        b.start();
        Thread.sleep(5000);
        System.out.println();
    }
}
