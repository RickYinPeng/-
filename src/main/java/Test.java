import java.util.Scanner;

/**
 * @author RickYinPeng
 * @ClassName Test
 * @Description
 * @date 2019/3/30/19:46
 */
public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        String string = Integer.toBinaryString(x);
        char[] chars = string.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if(aChar=='1'){
                count++;
            }
        }
        System.out.println(count);


    }
}
