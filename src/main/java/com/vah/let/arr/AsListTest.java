package com.vah.let.arr;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author Jiang
 * @Date 2021/8/26 10:56 上午
 **/
public class AsListTest {
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        List list = Arrays.asList(arr);
        Integer [] arr2 = {1,2,3};
        List<Integer> integers = Arrays.asList(arr2);
        System.out.println();
    }
}
