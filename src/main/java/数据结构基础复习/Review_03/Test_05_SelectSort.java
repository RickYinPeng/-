package 数据结构基础复习.Review_03;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName Test_05_SelectSort
 * @Description 简单选择排序
 * @date 2019/2/18/10:38
 */
public class Test_05_SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,7,1,2,0,3,6,8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr){
        //遍历所有的树
        for(int i = 0;i<arr.length;i++){
            int minIndex = i;
            //把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数的下标
            for(int j = i+1;j<arr.length;j++){
                //如果后面比较的数比记录的最小的数小
                if(arr[j]<arr[minIndex]){
                    //记录下最小的数的下标
                    minIndex = j;
                }
            }
            //如果最小的数和当前遍历的数的下标不一致,说明下标为minIndex的数比当前遍历的更小
            if(i!=minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
