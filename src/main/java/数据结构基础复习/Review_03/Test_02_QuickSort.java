package 数据结构基础复习.Review_03;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName Test_02_QuickSort
 * @Description 快速排序
 * @date 2019/2/14/11:36
 */
public class Test_02_QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,7,2,7,2,8,0};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int start,int end){
        if(start<end) {

            //把数组中的第0个数字作为标准数
            int stand = arr[start];

            //需要记录排序的下标
            int low = start;
            int high = end;

            //循环找比标准数大的数和比标准数小的数
            while (low < high) {
                //右边的数字比标准数大
                while (low < high && arr[high] >= stand) {
                    high--;
                }
                //使用右边的数字替换左边的数字
                arr[low] = arr[high];

                //如果左边的数字比标准数小
                while (low < high && arr[low] <= stand) {
                    low++;
                }
                //使用左边的数字替换右边的
                arr[high] = arr[low];
            }

            //将标准值放入low和high重合的地方
            arr[low] = stand;

            //递归左边小的数字
            quickSort(arr, start, low);

            //递归右边的
            quickSort(arr, low+1 , end);
        }
    }
}
