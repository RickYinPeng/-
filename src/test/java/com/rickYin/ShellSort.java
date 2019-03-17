package com.rickYin;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName ShellSort
 * @Description 希尔排序
 * @date 2019/2/18/10:20
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,5,6,7,3,8,9};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        //遍历所有的步长
        for(int d = arr.length/2;d>0;d /=2){
            //遍历所有的元素
            for(int i = d;i<arr.length;i++){
                for(int j = i-d;j>=0;j++){
                    if(arr[j]>arr[j+d]){
                        int temp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = temp;
                    }
                }
            }
        }
    }
}
