package com.rickYin.test;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName Test_02_归并排序
 * @Description
 * @date 2019/3/30/16:49
 */
public class Test_02_归并排序 {
    public static void main(String[] args) {
        int[] a = {2,1,4,33,2,53,6,8,4,9,10};
        System.out.println("排序前："+ Arrays.toString(a));
        merge_sort(a,a.length);
        System.out.println("排序后："+ Arrays.toString(a));
    }

    public static void merge_sort(int[] a, int n) {
        merge_sort_c(a, 0, n - 1);
    }

    private static void merge_sort_c(int[] a, int start, int end) {
        if(start>=end) return;

        int mid = start+((end-start)>>1);

        merge_sort_c(a,start,mid);
        merge_sort_c(a,mid+1,end);
        merge(a,start,mid,end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        //用于指向左边数组的指针
        int i = start;
        //用于指向右边数组的首指针
        int j = mid+1;

        int k = 0;
        int[] temp = new int[end-start+1];

        while (i<=mid && j<=end){
            if(a[i]>a[j]){
                temp[k++] = a[j++];
            }else{
                temp[k++] = a[i++];
            }
        }

        //判断哪个子数组中有数据
        int start2 = i;
        int end2 = mid;
        if(j<=end){
            start2 = j;
            end2 = end;
        }

        //将剩余数据拷贝到新数组中
        while (start2<=end2){
            temp[k++] = a[start2++];
        }

        //将temp中的数据拷贝回原数组
        int index = 0;
        for(int x = start;x<=end;x++){
            a[x] = temp[index++];
        }

    }

}
