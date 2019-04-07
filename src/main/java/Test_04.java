import java.util.Arrays;

/**
 * @author RickYinPeng
 * @ClassName Test_04
 * @Description
 * @date 2019/4/2/20:01
 */
public class Test_04 {
    public static void main(String[] args) {
        //minNumberOfProjects(4,3,)
    }

    public static int minNumberOfProjects(int num, int projCmptDec, int restDec,
                                   int[] errorScore) {
        Arrays.sort(errorScore);
        int sum = 0;
        for (int i : errorScore) {
            sum += i;
        }
        int dec = projCmptDec+(num-1)*restDec;
        int count = 0;
        while (sum>0){
            count++;
        }

        return count;
    }
}
