package 数据结构基础复习.Review_03;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName Test_04_ShellSort
 * @Description 希尔排序
 * @date 2019/2/16/11:03
 */
public class Test_04_ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,5,6,7,3,8,9};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        //遍历所有的步长
        for(int d = arr.length/2;d>0;d /=2){
            //遍历所有元素
            for(int i = d;i<arr.length;i++){
                //遍历本组中所有元素
                for(int j = i-d;j>=0;j-=d){
                    //如果当前元素大于加上步长后的那个元素
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
