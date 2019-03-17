package 数据结构基础复习.Review_04;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName HeapSort
 * @Description 堆排
 * @date 2019/2/17/16:35
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,6,8,7,0,1,10,4,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将数组转成大根堆
     * @param arr     要转换的数组
     * @param size    因为我需要转换很多次对吧（最后一个最大的我们就不调整了），所以需要转换多少
     * @param index   从哪里开始转换（最后一个非叶子节点的位置）
     */
    public static void maxHeap(int[] arr,int size,int index){
        //左子节点
        int leftNode = 2*index+1;

        //右子节点
        int rightNode = 2*index+2;

        //和两个子节点分别对比，找出最大的节点
        int max = index;//最初我认为自己最大
        if(leftNode<size && arr[leftNode]>arr[max]){
            max = leftNode;
        }
        if(rightNode<size && arr[rightNode]>arr[max]){
            max = rightNode;
        }

        //拿到最大的后，我们需要交换位置
        if(max !=index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            /**
             * 注意：我们交换完了后，上移的是大的数字我们不用管，
             *      但是下移的是小的数字，如果下移的数字还有子节点，
             *      我们就需要拿着这个下移的节点和它的子节点再去比较
             */
            //交换位置以后，可能会破坏之前排好的堆，所以，之前的排好的堆需要重写调整
            maxHeap(arr,size,max);
        }
    }

    public static void heapSort(int[] arr){
        //开始位置是最后一个非叶子节点，即最后一个节点的父节点
        int start = (arr.length-1)/2;

        //调整为大根堆
        for(int i = start;i>=0;i-- ){
            maxHeap(arr,arr.length,i);
        }
        /*System.out.println(Arrays.toString(arr));*/

        //先把数组中的第0个和堆中的最后一个数交换位置，再把前面的处理为大根堆
        for(int i = arr.length-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr,i,0);
        }
    }



}
