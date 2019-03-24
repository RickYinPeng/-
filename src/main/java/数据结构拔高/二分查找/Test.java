package 数据结构拔高.二分查找;

import java.util.Scanner;

/**
 * @author RickYinPeng
 * @ClassName Test
 * @Description
 * @date 2019/3/24/19:06
 */
public class Test {
    public static void main(String[] args) {
        int[] a = new int[7];
        Scanner sc = new Scanner(System.in);
        for(int i = 1;i<7;i++){
            int n = sc.nextInt();
            a[i] = n;
        }
        int max = 36;
        int count = 0;
        while (!isEmpty(a)){
            max = 36;
            if(a[6]>0 && max>=36){
                a[6]--;
                max -= 36;
            }
            while (a[5]>0 && max>25){
                a[5]--;
                max-=25;
            }
            while (a[4]>0 && max>16){
                a[4]--;
                max-=16;
            }
            while (a[3]>0 && max>9){
                a[3]--;
                max-=9;
            }
            while (a[2]>0 && max>4){
                a[2]--;
                max-=4;
            }
            while (a[1]>0 && max>1){
                a[1]--;
                max-=1;
            }
            count++;
        }

        System.out.println(count);
    }

    private static boolean isEmpty(int[] a) {
        for(int i = 1;i<a.length;i++){
            if(a[i]!=0){
                return false;
            }
        }
        return true;
    }

}
