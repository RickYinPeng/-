package 数据结构拔高.排序;

/**
 * @author RickYinPeng
 * @ClassName 插入排序
 * @Description
 * @date 2019/3/15/20:22
 * <p>
 * 1、插入排序是原地排序算法吗？
 * 从实现过程可以很明显地看出，插入排序算法的运行并不需要额外的存储空间，所以空间复杂度是O(1)，也就是说，这是一个原地排序算法。
 * 2、插入排序是稳定的排序算法吗？
 * 在插入排序中，对于值相同的元素，我们可以选择将后面出现的元素，插入到前面出现元素的后面，这样就可以保持原有的前后顺序不变，所以插入排序是稳定
 * 的排序算法。
 * 3、插入排序的时间复杂度是多少？
 * 如果要排序的数据已经是有序的，我们并不需要搬移任何数据。如果我们从尾到头在有序数据组里面查找插入位置，每次只需要比较一个数据就能确定插入的位
 * 置。所以这种情况下，最好是时间复杂度为O(n)。注意，这里是从尾到头遍历已经有序的数据。
 * 如果数组是倒序的，每次插入都相当于在数组的第一个位置插入新的数据，所以需要移动大量的数据，所以最坏情况时间复杂度为O(n2)。
 */
public class 插入排序 {

    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            /**
             * 查找插入位置
             */
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 时间复杂度：O(n平方)
     * @param a
     * @param n
     */
    public void insertionSort_2(int[] a, int n) {
        if (n < 1) return;
        /**
         * O(n)
         */
        for(int i = 1;i<n;i++){
            int value = a[i];
            int j = i-1;
            /**
             * O(n)
             */
            for(;j>=0;j--){
                if(a[j]>value){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}
