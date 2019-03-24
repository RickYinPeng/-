package 数据结构拔高.二分查找;

/**
 * @author RickYinPeng
 * @ClassName Test_03_查找第一个大于等于给定值的元素
 * @Description
 * @date 2019/3/24/13:09
 */
public class Test_03_查找第一个大于等于给定值的元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,7,10};
        int index = bsearch(arr, arr.length, 5);
        System.out.println(index);
    }
    public static int bsearch(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low+((high-low)>>1);
            if(value>a[mid]){
                low = mid+1;
            }else if(value<=a[mid]){
                if((mid==0)||a[mid-1]<value){
                    return mid;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

}
