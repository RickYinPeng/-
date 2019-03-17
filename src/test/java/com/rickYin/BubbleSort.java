package com.rickYin;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName BubbleSort
 * @Description
 * @date 2019/2/17/11:09
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{ 2, 5, 3, 1, 4 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr.length > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean flag = false;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag = true;
                    }
                }
                if (!flag) {
                    break;
                }
            }
        }
    }
}
