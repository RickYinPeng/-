package jvm.虚拟机类加载机制;

/**
 * @author RickYinPeng
 * @ClassName 被动引用
 * @Description
 * @date 2019/3/16/15:03
 */
public class 被动引用 {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        System.out.println(ConstClass.Helloworld);
    }

}

class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static final String Helloworld = "hello world";
}

