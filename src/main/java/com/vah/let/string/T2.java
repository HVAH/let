package com.vah.let.string;

import java.util.Arrays;

/**
 * @Description
 * @Author Jiang
 * @Date 2021/9/8 3:42 下午
 **/
public class T2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("a;b;c;d".split("((?<=;)|(?=;))")));
    }
}
