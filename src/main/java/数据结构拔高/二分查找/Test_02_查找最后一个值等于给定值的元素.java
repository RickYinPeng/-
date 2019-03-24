package 数据结构拔高.二分查找;

/**
 * @author RickYinPeng
 * @ClassName Test_02_查找最后一个值等于给定值的元素
 * @Description
 * @date 2019/3/24/13:03
 */
public class Test_02_查找最后一个值等于给定值的元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,5,6,8,8,8,11,18};
        int index = bsearch(arr, arr.length, 8);
        System.out.println(index);
    }

    public static int bsearch(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low+((high-low)>>1);
            if(value>a[mid]){
                low = mid+1;
            }else if(value<a[mid]){
                high = mid-1;
            }else {
                if((mid==n-1)||a[mid+1]!=value){
                    return mid;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
