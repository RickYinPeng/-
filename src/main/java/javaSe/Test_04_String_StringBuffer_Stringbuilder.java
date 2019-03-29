package javaSe;

/**
 * @author RickYinPeng
 * @ClassName Test_04_String_StringBuffer_Stringbuilder
 * @Description
 * @date 2019/3/28/8:43
 */
public class Test_04_String_StringBuffer_Stringbuilder {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        Integer integer = new Integer(3);

        Integer a = Integer.valueOf(123);
        Integer b = Integer.valueOf(123);
        System.out.println(a==b);

        Integer c = Integer.valueOf(300);
        Integer d = Integer.valueOf(300);
        System.out.println(c==d);
    }
}


