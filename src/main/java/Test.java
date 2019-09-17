import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author RickYinPeng
 * @ClassName Test
 * @Description
 * @date 2019/3/30/19:46
 */
public class Test {
    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.get();


//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//
//        String string = Integer.toBinaryString(x);
//        char[] chars = string.toCharArray();
//        int count = -0;
//        for (char aChar : chars) {
//            if(aChar=='1'){
//                count++;
//            }
//        }
//        System.out.println(count);
//        ArrayList arrayList = new ArrayList();
//        HashMap hashMap = new HashMap();
//        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int[] a = {3,5,7,1,1,1,1};
        int[] b = {1,2,3,4,5,5,5,5,5,5,6};
        int major = getMajor(a, a.length);
        System.out.println(major);
    }

    static int getMajor(int[] a,int n){
        int x = 0,count = 0;
        for(int i = 0; i< n ;i++){
            if(count ==0){
                x = a[i];
                count++;
            }else if(a[i] == x){
                count++;
            }else {
                count--;
            }
        }
        return x;
    }



}
