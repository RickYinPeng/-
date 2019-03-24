package 数据结构拔高.二分查找;

/**
 * @author RickYinPeng
 * @ClassName Test_04_查找最后一个小于等于给定值的元素
 * @Description
 * @date 2019/3/24/15:50
 */
public class Test_04_查找最后一个小于等于给定值的元素 {
    public static void main(String[] args) {

    }
    public static int bsearch(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low+((high-low)>>1);
            if(value<a[mid]){
                high = mid-1;
            }else if(value>=a[mid]){
                if((mid==(n-1))||a[mid+1]>value){
                    return mid;
                }else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
