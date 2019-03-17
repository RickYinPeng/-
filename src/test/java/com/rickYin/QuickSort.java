package com.rickYin;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName QuickSort
 * @Description 快速排序
 * @date 2019/2/17/11:15
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 7, 2, 8, 0};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int stand = arr[begin];

            int high = end;
            int low = begin;

            while (low < high) {
                while (low<high && arr[high] >= stand) {
                    high--;
                }
                arr[low] = arr[high];

                while (low <high && arr[low] <= stand) {
                    low++;
                }
                arr[high] = arr[low];
            }

            arr[low] = stand;

            quickSort(arr, begin, low);
            quickSort(arr, low+1, end);
        }
    }
}
