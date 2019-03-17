package 数据结构基础复习.Review_03;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName Test_01_BubbleSort
 * @Description 冒泡排序
 * @date 2019/2/14/10:50
 */
public class Test_01_BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        //System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    /**
     * 5,7,4,5,3,8,6,9,1 0   共需要比较 length-1 轮
     *
     * 第一轮：
     * 5,7,4,5,3,8,6,9,10
     * 5,4,7,5,3,8,6,9,10
     * 5,4,5,7,3,8,6,9,10
     * 5,4,5,3,7,8,6,9,10
     * 5,4,5,3,7,8,6,9,10
     * 5,4,5,3,7,6,8,9,10
     * 5,4,5,3,7,6,8,9,10
     * 5,4,5,3,7,6,8,9,10
     */
    public static void bubbleSort(int[] arr){
        //对冒泡排序的一种优化
        boolean flag = false;

        //控制比较共比较多少轮
        for(int i = 0;i<arr.length-1;i++){
            //每一轮比较的次数
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                    System.out.println("花花");
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
