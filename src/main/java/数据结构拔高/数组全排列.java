package 数据结构拔高;

/**
 * @author RickYinPeng
 * @ClassName 数组全排列
 * @Description
 * @date 2019/3/30/18:40
 */
public class 数组全排列 {
    public static void main(String[] args) {
        int[] a={1, 2,3, 4};
        printPermutations(a, 4, 4);
    }

    public static void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
            printPermutations(data, n, k - 1);
            tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;
        }
    }
}
