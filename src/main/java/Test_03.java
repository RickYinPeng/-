import java.util.Scanner;

/**
 * @author RickYinPeng
 * @ClassName Test_03
 * @Description
 * @date 2019/3/30/20:31
 */
public class Test_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int key = sc.nextInt();
        int count = 0;
        for(int i = 0;i<x;i++){
            int ge = 0;
            int shi = 0;
            int bai = 0;

            if(i<10){
                ge = i;
            }else if(i>9 && i<100){
                ge = i%10;
                shi = i/10;
            }else{
                ge = 0;
                shi = 0;
                bai = 1;
            }
            for(int j = 0;j<y;j++){
                int ge_1 = 0;
                int shi_1 = 0;
                int bai_1 = 0;
                if(i<10){
                    ge_1 = j;
                }else if(j>9 && j<100){
                    ge_1 = j%10;
                    shi_1 = j/10;
                }else{
                    ge_1 = 0;
                    shi_1 = 0;
                    bai_1 = 1;
                }
                if((ge+shi+bai+ge_1+shi_1+bai_1)<=key){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
