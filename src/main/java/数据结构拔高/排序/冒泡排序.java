package 数据结构拔高.排序;

import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName 冒泡排序
 * @Description
 * @date 2019/3/15/19:54
 *
 * 1、冒泡排序是原地排序算法吗？
 * 冒泡的过程只涉及相邻数据的交换操作，只需要常量级的临时空间，所以它的空间复杂度为O(1)，是一个原地排序算法。
 *
 * 2、冒泡排序是稳定的排序算法吗？
 * 在冒泡排序中，只有交换才可以改变两个元素的前后顺序。为了保证冒泡排序算法的稳定性，当有相邻的两个元素大小相等的时候，我们不做交换，相同大小的
 * 数据在排序前后不会改变顺序，所以冒泡排序是稳定的排序算法。
 *
 * 3、冒泡排序的时间复杂度是多少？
 * 最好情况下，要排序的数据已经是有序的了，我们只需要进行一次冒泡操作，就可以结束了，所以最好情况时间复杂度是O(n)。而最坏的情况是，要排序的数据
 * 刚好是倒序排列的，我们需要进行n次冒泡操作，所以最坏情况时间复杂度为O(n2)。
 * 最好、最坏情况下的时间复杂度很容易分析，那平均情况下的时间复杂是多少呢？我们前面讲过，平均时间复杂度就是加权平均期望时间复杂度，分析的时候要
 * 结合概率论的知识。
 * 对于包含n个数据的数组，这n个数据就有n!种排列方式。不同的排列方式，冒泡排序执行的时间肯定是不同的。比如我们前面举的那两个例子，其中一个要进
 * 行6次冒泡，而另一个只需要4次。如果用概率论方法定量分析平均时间复杂度，涉及的数学推理和计算就会很复杂。我这里还有一种思路，通过“有序度”和“逆序
 * 度”这两个概念来进行分析。
 * 有序度是数组中具有有序关系的元素对的个数。有序元素对用数学表达式表示就是这样：有序元素对：a[i] <= a[j], 如果i < j。
 * 同理，对于一个倒序排列的数组，比如6，5，4，3，2，1，有序度是0；对于一个完全有序的数组，比如1，2，3，4，5，6，有序度就是n*(n-1)/2，也就是15。
 * 我 们把这种完全有序的数组的有序度叫作满有序度。
 * 逆序度的定义正好跟有序度相反（默认从小到大为有序），我想你应该已经想到了。关于逆序度，我就不举例子讲了。你可以对照我讲的有序度的例子自己看下。
 * 关于这三个概念，我们还可以得到一个公式：逆序度=满有序度-有序度。我们排序的过程就是一种增加有序度，减少逆序度的过程，最后达到满有序度，就说明
 * 排序完成了。
 * 我还是拿前面举的那个冒泡排序的例子来说明。要排序的数组的初始状态是4，5，6，3，2，1 ，其中，有序元素对有(4，5) (4，6)(5，6)，所以有序度是3。n=6，
 * 所以排序完成之后终态的满有序度为n*(n-1)/2=15。
 * 冒泡排序包含两个操作原子，比较和交换。每交换一次，有序度就加1。不管算法怎么改进，交换次数总是确定的，即为逆序度，也就是n*(n-1)/2–初始有序度。
 * 此例中就是15–3=12，要进行12次交换操作。
 * 对于包含n个数据的数组进行冒泡排序，平均交换次数是多少呢？最坏情况下，初始状态的有序度是0，所以要进行n*(n-1)/2次交换。最好情况下，初始状态的有序
 * 度是n*(n-1)/2，就不需要进行交换。我们可以取个中间值n*(n-1)/4，来表示初始有序度既不是很高也不是很低的平均情况。
 * 换句话说，平均情况下，需要n*(n-1)/4次交换操作，比较操作肯定要比交换操作多，而复杂度的上限是O(n2)，所以平均情况下的时间复杂度就是O(n2)。
 *
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] a = {3,1,4,2,6,3,5,8,3,9,10};

        bubbleSort(a,a.length);
    }


    public static void bubbleSort(int[] a, int n) {
        System.out.println("排序前："+ Arrays.toString(a));
        if (n <= 1) return;

        for(int i = 0;i<n;i++){
            boolean flag = false;
            for(int j = i+1;j<n-1-i;j++){
                if(a[j-1]>a[j]){
                    flag = true;
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println("排序后："+Arrays.toString(a));
    }
}
