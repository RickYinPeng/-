package 滴滴笔试;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //区间大小
        int m = sc.nextInt();
        int[] attr = new int[n];
        for (int i = 0; i < n; i++) {
            attr[i] = sc.nextInt();
        }
//        //区间最小和
//        int min = 0;
//        boolean flag = true;
//        for (int i = 0; i < attr.length-m+1; i++) {
//            //区间大小为m时的和
//            int sum = 0;
//            int tmp;
//            int index = 0;
//            for (int j = 0; j < m; j++) {
//                tmp = attr[(i + j)];
//                sum += tmp;
//                index = i+j;
//            }
//            for(int z = index+1;z<attr.length;z++){
//                if ((sum+attr[z])<min){
//                    sum += attr[z];
//                }
//            }
//            if (flag) {
//                min = sum;
//                flag = false;
//            } else {
//                if (sum < min) {
//                    min = sum;
//                }
//            }
//        }
//        System.out.println(min);
//        Scanner sc = new Scanner(System.in);
//        String[] line1 = sc.nextLine().split(" ");
//        int n = Integer.valueOf(line1[0]);
//        int m = Integer.valueOf(line1[1]);
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = sc.nextInt();
//        }
//
//        int[] sum = new int[n];
//        int[] start = new int[n];
//        int min = 0;
//        for (int i = 0; i < m; i++) {
//            min += array[i];
//            sum[i] = Integer.MAX_VALUE;
//        }
//        sum[m - 1] = min;
//        start[m - 1] = 0;
//        for (int i = m; i < n; i++) {
//            int s = 0;
//            for (int j = start[i - 1]; j < i - m + 1; j++) {
//                s += array[j];
//            }
//            if (s > 0) {
//                start[i] = i - m + 1;
//                sum[i] = sum[i-1] + array[i] - s;
//            } else {
//                start[i] = start[i-1];
//                sum[i] = sum[i-1] + array[i];
//            }
//            if (sum[i] < min) {
//                min = sum[i];
//            }
//        }
//
//        System.out.println(min);

    }
}
