package 腾讯笔试;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] att = new int[n][2];
        for (int i = 0; i < n; i++) {
            att[i][0] = sc.nextInt();
            att[i][1] = sc.nextInt();
        }
    }
}
