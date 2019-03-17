package 数据结构拔高.排序;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName 快速排序
 * @Description
 * @date 2019/3/16/20:16
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {2,1,4,5,2,3,5,7,2,3,5};
        System.out.println("排序前："+Arrays.toString(arr));
        quickSort(arr, arr.length);
        System.out.println("排序后："+Arrays.toString(arr));
    }

    //快速排序，a是数组，n表示
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a,p,r);//获取分区点;
        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);
    }

    private static int partition(int[] a, int p, int r) {
        //区分点
        int pivot = a[r];
        //指向已处理区间的尾部
        int i = p;
        //j从头到尾遍历，如果取到小于区分点的数，则将其于已处理区间的尾部交换
        for(int j = p;j<r;j++){
            if(a[j]<pivot){
                if(i==j){
                    i++;
                }else{
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }
            }
        }
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        System.out.println("i="+i);
        return i;
    }
}
