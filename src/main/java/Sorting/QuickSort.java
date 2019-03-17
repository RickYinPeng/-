package Sorting;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName QuickSort
 * @Description 快速排序
 * @date 2019/2/15/11:30
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1,2,4,3,6};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int start,int end){
        if(start<end) {
            int stand = arr[start];

            int high = start;
            int low = end;

            while (low < high) {
                while (low < high && arr[high] >= stand) {
                    high--;
                }
                arr[low] = arr[high];

                while (low < high && arr[low] <= stand) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stand;

            quickSort(arr, start, low);

            quickSort(arr, low + 1, end);
        }
    }
}
