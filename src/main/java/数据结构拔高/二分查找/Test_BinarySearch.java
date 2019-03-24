package 数据结构拔高.二分查找;

/**
 * @author RickYinPeng
 * @ClassName Test_BinarySearch
 * @Description
 * @date 2019/3/23/11:46
 */
public class Test_BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{5,3,7,5,6,9,1,4,7,10};
        int index = bsearch(a, a.length, 10);
        System.out.println(index);
    }

    /**
     * 非递归形式
     * @param a 数组
     * @param n 数组长度
     * @param value 要查找的值
     * @return
     */
    public static int bsearch(int[] a,int n,int value ){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = (low+high)>>1;
            if(value==a[mid]){
                return mid;
            }else if(value>a[mid]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     * @param a 数组
     * @param n 数组长度
     * @param value 要查找的值
     * @return
     */
    public static int bsearch_DG(int[] a,int n,int value){
        return bsearchInternally(a,0,n-1,value);
    }
    private static int bsearchInternally(int[] a, int low, int high, int value) {
        if(low>high) return -1;
        int mid = low+((high-low)>>2);
        if(value==a[mid]){
            return mid;
        }else if(value>a[mid]){
            return bsearchInternally(a,mid+1,high,value);
        }else {
            return bsearchInternally(a,low,mid-1,value);
        }
    }
}
