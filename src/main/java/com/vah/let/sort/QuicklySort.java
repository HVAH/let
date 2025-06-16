package com.vah.let.sort;

import com.vah.let.algorithm.dynamicplanning.Rob;

import java.util.Arrays;

/**
 * @Description
 * @Author vahuang
 **/
public class QuicklySort {
    public static void main(String[] args) {
//        key = 5
        int[] arr = {5, 2, 3, 1, 4, 6, 7, 9, 8};
//        left = 0; right = 4
//        int[] arr = {4, 2, 3, 1, 4, 6, 7, 9, 8};
//        left = 4 right = 4
//        int[] arr = {4, 2, 3, 1, 5, 6, 7, 9, 8};

        quicklySort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void quicklySort(int[] arr, int left, int right) {
        if (left < right) {
            int aStandardPoint = qquicklySort(arr, left, right);
            quicklySort(arr, 0,left - 1);
            quicklySort(arr, left + 1, right);
        }
    }

    private static int qquicklySort(int[] arr, int left, int right) {
        // 选取一个key  作为标准点
        int key = arr[left];
        while (left < right) {
            // 高位向低位移动 直到这个数比基数小
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            System.out.println(String.format("left:%s;right:%s", left, right));
            pr(arr);
            // 低位向高位移动，直到这个数比基数大
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
            System.out.println(String.format("left:%s;right:%s", left, right));
            pr(arr);
            arr[left] = key;
            System.out.println(String.format("left:%s;right:%s", left, right));
            pr(arr);
        }
        return left;
    }

    private static void pr(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
