package com.vah.let.sort;

/**
 * @Description 插入排序
 * @Author vahuang
 * @Date 2025/6/24 17:36
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 4, 6, 7, 9, 8};
//        left = 0; right = 4
//        int[] arr = {4, 2, 3, 1, 4, 6, 7, 9, 8};
//        left = 4 right = 4
//        int[] arr = {4, 2, 3, 1, 5, 6, 7, 9, 8};

        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

   public static void insertSort(int [] arr) {
        for (int i= 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i;
            while (insertIndex - 1 >= 0 && insertValue < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            arr[insertIndex] = insertValue;
        }
   }
}
