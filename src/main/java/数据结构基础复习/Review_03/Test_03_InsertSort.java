package 数据结构基础复习.Review_03;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName Test_03_InsertSort
 * @Description 插入排序
 * @date 2019/2/15/12:04
 */
public class Test_03_InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,8,5,9,10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            //如果当前数字比前一个数字小
            if(arr[i]<arr[i-1]){
                //将当前遍历的数字存起来
                int temp = arr[i];
                //遍历当前数字前面所有的数字
                int j;
                for(j = i-1;j>=0 && temp<arr[j];j--){
                    //
                    arr[j+1] = arr[j];
                }
                arr[j+1] = temp;
            }
        }
    }
}
