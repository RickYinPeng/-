/**
 * @author RickYinPeng
 * @ClassName Test_02
 * @Description
 * @date 2019/3/30/20:04
 */
public class Test_02 {
    public static void main(String[] args) {
        String[] s = new String[]{"10","5","1","5","3","7","13","18"};
        test(s,1);
        if(flag){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
    static boolean flag = true;
    public static void test(String[] a,int root){
        int left = root*2;
        if(left<a.length && !a[left].equals("None")){
            test(a,left);
        }
        if(left>=a.length || a[left].equals("None")){
            return;
        }
        int right = root*2+1;
        if(right<a.length && !a[right].equals("None")){
            test(a,right);
        }
        if(right>=a.length || a[right].equals("None")){
            return;
        }
        if(Integer.valueOf(a[left])>Integer.valueOf(a[root]) ||
                Integer.valueOf(a[right])<Integer.valueOf(a[root])) {
            flag = false;
        }
    }
}
