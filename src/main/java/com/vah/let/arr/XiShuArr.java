package com.vah.let.arr;

import java.util.Objects;

/**
 * @Description 稀疏数组
 * 定义：
 * @Author Jiang
 * @Date 2021/8/23 3:31 下午
 **/
public class XiShuArr {

    public static void main(String[] args) {
        XiShuArr a = null;
        XiShuArr b = null;
        System.out.println(a == b);
        System.out.println(Objects.equals(a, b));
        int[][] arr = new int[11][11];
        arr[0][1] = 1;
        arr[1][2] = 2;

        for (int[] ints : arr) {
            for (int anInt : ints) {

                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        int[][] result = transferXiShuArr(arr);

        System.out.println();

        for (int[] ints : result) {
            for (int anInt : ints) {

                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }

    /**
     * 转换成稀疏数组
     *
     * @param arr
     * @return
     */
    private static int[][] transferXiShuArr(int[][] arr) {
        int count = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                }
            }
        }
        int[][] result = new int[count + 1][3];
        result[0][0] = arr.length;
        result[0][1] = arr[0].length;
        result[0][2] = count;
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    result[k][0] = i;
                    result[k][1] = j;
                    result[k][2] = arr[i][j];
                    k++;
                }
            }
        }
        return result;
    }
}
