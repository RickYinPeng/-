package 数据结构基础复习.Review_02;

/**
 * @author RickYinPeng
 * @ClassName 数据结构基础复习.Review_02.Test_03_Hanoi
 * @Description 递归解决汉诺塔问题,可以看看4399小游戏中的哈诺塔游戏，试着玩一下
 *  * @date 2019/2/13/16:00
 */
public class Test_03_Hanoi {
    public static void main(String[] args) {
        hanoi(6,'A','B','C');
    }

    /**
     * @param n     共有n个盘子
     * @param from  开始的柱子
     * @param in    中间的柱子
     * @param to    目标柱子
     *
     * 无论有多少个盘子，都认为只有两个。上面的所有盘子和最下面的一个盘子
     */
    public static void hanoi(int n,char from,char in,char to){
        if(n==1){
            System.out.println("第"+1+"个盘子从"+from+"移到"+to);
        }else {
            //移动上面的所有盘子到中间位置
            hanoi(n-1,from,to,in);
            //移动下面的盘子
            System.out.println("第"+n+"个盘子从"+from+"移到"+to);
            //把上面的所有盘子从中间位置移到目标位置
            hanoi(n-1,in,from,to);
        }
    }
}
