package jvm.虚拟机类加载机制;

/**
 * @author RickYinPeng
 * @ClassName 字段解析
 * @Description
 * @date 2019/3/18/0:15
 */
public class 字段解析 {
    interface Interface0{
        int A = 0;
    }
    interface Interface1 extends Interface0{
        int A = 1;
    }

    interface Interface2{
        int A = 2;
    }

    static class Parent implements Interface1{
        public static int A = 3;
    }


    static class Sub extends Parent implements Interface2{
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
