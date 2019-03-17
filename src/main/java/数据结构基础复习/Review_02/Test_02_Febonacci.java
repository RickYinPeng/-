package 数据结构基础复习.Review_02;

/**
 * @author RickYinPeng
 * @ClassName 数据结构基础复习.Review_02.Test_02_Febonacci
 * @Description 递归菲波那切数列
 * @date 2019/2/13/15:47
 */
public class Test_02_Febonacci {
    public static void main(String[] args) {
        //菲波那切数列：1,1,2,3,5,8,13......
        int febonacci = febonacci(100);
        System.out.println(febonacci);
    }

    //打印第n项的菲波那切数列
    public static int febonacci(int i){
       if(i==1 || i==2){
           return 1;
       }else{
           return febonacci(i-1)+febonacci(i-2);
       }
    }
}
