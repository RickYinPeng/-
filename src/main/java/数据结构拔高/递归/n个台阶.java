package 数据结构拔高.递归;

import java.util.HashMap;

/**
 * @author RickYinPeng
 * @ClassName n个台阶
 * @Description
 * @date 2019/3/14/10:58
 */
public class n个台阶 {

    public static void main(String[] args) {
        int n = 8;
        int f = f2(n);
        System.out.println(f);

    }
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static int f(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int result = f(n-1)+f(n-2);
        map.put(n,result);

        return result;
    }

    static int f2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }

}
