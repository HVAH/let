package com.vah.let.math;

/**
 * @Description
 * @Author Jiang
 * @Date 2021/8/30 3:42 下午
 **/
public class T2 {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;

        if (a - b < 0) {
            System.out.println("a - b < 0");
        }
        if (a <b) {
            System.out.println("a < b");
        }

    }
}
