package javaSe;

/**
 * @author RickYinPeng
 * @ClassName Test_02_Extend
 * @Description
 * @date 2019/3/22/14:15
 */
public class Test_02_Extend {
    public static void main(String[] args) {
        Father f = new Son();
        f.eat();
    }
}

class Father {
    public static void eat() {
        System.out.println("Father");
    }
}

class Son extends Father {
    public static void eat() {
        System.out.println("Son");
    }
}