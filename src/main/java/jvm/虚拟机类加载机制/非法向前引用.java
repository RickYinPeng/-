package jvm.虚拟机类加载机制;

/**
 * @author RickYinPeng
 * @ClassName 非法向前引用
 * @Description
 * @date 2019/3/18/0:22
 */
public class 非法向前引用 {
    static {
        i = 0;
        /**
         * 报错  
         */
        //System.out.println(i);
    }
    static int i = 1;
}
