package 数据结构基础复习.Review_04.二叉排序树;

/**
 * @author RickYinPeng
 * @ClassName TestBinarySortTree
 * @Description
 * @date 2019/2/20/12:05
 */
public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9};

        //创建一棵二叉排序树
        BinarySortTree binarySortTree = new BinarySortTree();

        //循环添加
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        //查看树中的值，中序遍历
        binarySortTree.midShow();
        System.out.println("----------------------");
        binarySortTree.delete(7);
        binarySortTree.midShow();
    }
}
