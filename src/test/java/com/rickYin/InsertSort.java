package com.rickYin;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName InsertSort
 * @Description 插入排序
 * @date 2019/2/17/11:42
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,8,5,9,10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                int j;
                for(j = i-1;j>=0 && temp<arr[j];j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;

            }
        }
    }

}
