package 数据结构拔高.二分查找;
import java.util.Scanner;

public class Main {

    static String GetResult(int N) {

        String[] arr={"1/1",

                "1/2","2/1",

                "3/1","2/2","1/3",

                "1/4","2/3","3/2","4/1",

                "5/1","4/2","3/3","2/4","1/5",

                "1/6","2/5","3/4","4/3","5/2","6/1",

                "7/1","6/2","5/3","4/4","3/5","2/6","1/7"};

        return arr[N-1];

    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        String res;
        int _N;

        _N = Integer.parseInt(in.nextLine().trim());
        res = GetResult(_N);

        System.out.println(res);

    }

}
