package Sorting;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * @date 2019/2/15/11:24
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,1,2,4,3,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        if(arr.length>0){
            for(int i = 0;i<arr.length-1;i++){
                boolean flag = false;
                for(int j = 0;j<arr.length-1-i;j++){
                    if(arr[j]>arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        flag = true;
                    }
                }
                if (!flag){
                    break;
                }
            }
        }


    }

}
