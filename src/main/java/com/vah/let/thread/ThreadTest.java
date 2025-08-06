package com.vah.let.thread;

/**
 */
public class ThreadTest {
	public static void main(String[] args) {
		int i = 0;
		while (i < 1000) {
			new Thread(() ->{
				while (true) {
					System.out.println("这是 " + Thread.currentThread().getName() + " 线程");
				}
			}).start();
			i++;
		}
	}

}
