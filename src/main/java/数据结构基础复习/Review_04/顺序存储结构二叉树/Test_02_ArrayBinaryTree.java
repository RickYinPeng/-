package 数据结构基础复习.Review_04.顺序存储结构二叉树;

/**
 * @author RickYinPeng
 * @ClassName Test_02_ArrayBinaryTree
 * @Description
 * @date 2019/2/17/14:14
 */
public class Test_02_ArrayBinaryTree {
    public static void main(String[] args) {
        int[] date = new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(date);

        //先序遍历
        arrayBinaryTree.frontShow();
    }
}
