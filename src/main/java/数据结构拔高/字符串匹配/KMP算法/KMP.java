package 数据结构拔高.字符串匹配.KMP算法;

/**
 * @author RickYinPeng
 * @ClassName KMP
 * @Description
 * @date 2019/4/30/23:48
 */
public class KMP {

    /**
     * kmp算法
     * @param a  主串
     * @param n  主串长度
     * @param b  模式串
     * @param m  模式串长度
     * @return
     */
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // 一直找到a[i]和b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     *
     * @param b 表示模式串
     * @param m 模式串的长度
     * @return
     */
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }
}
