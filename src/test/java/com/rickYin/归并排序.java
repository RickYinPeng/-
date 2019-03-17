package com.rickYin;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName 归并排序
 * @Description
 * @date 2019/3/17/22:49
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 33, 2, 53, 6, 8, 4, 9, 10};
        System.out.println("排序前：" + Arrays.toString(a));
        merge_sort(a, a.length);
        System.out.println("排序后：" + Arrays.toString(a));
    }

    private static void merge_sort(int[] a, int n) {
        merge_sort_c(a, 0, n - 1);
    }

    private static void merge_sort_c(int[] a, int start, int end) {
        if (start >= end) return;

        int q = (start + end) / 2;

        merge_sort_c(a, start, q);
        merge_sort_c(a, q + 1, end);
        merge(a, start, q, end);
    }

    private static void merge(int[] a, int start, int q, int end) {
        //用于指向左边数组的头指针
        int i = start;

        //用于指向右边数组的头指针
        int j = q + 1;

        int k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= q && j <= end) {
            if(a[i]>a[j]){
                temp[k++] = a[j++];
            }else {
                temp[k++] = a[i++];
            }
        }

        //判断哪个子数组中有数据
        int p = i;
        int r = q;
        if(j<=end){
            p = j;
            r = end;
        }

        //将剩余数组拷贝到原数组
        while (p<=r){
            temp[k++] = a[p++];
        }

        //temp数组拷贝回原数组
        for(i = 0;i<=end-start;i++){
            a[start+i] = temp[i];
        }
    }
}
