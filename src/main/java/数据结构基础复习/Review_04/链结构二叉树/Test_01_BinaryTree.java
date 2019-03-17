package 数据结构基础复习.Review_04.链结构二叉树;

/**
 * @author RickYinPeng
 * @ClassName Test_01_BinaryTree
 * @Description
 * @date 2019/2/16/12:42
 */
public class Test_01_BinaryTree {
    public static void main(String[] args) {
        /**
         * 创建了一棵树
         */
        BinaryTree binaryTree = new BinaryTree();

        //创建一个根节点
        TreeNode root = new TreeNode(1);

        //创建两个节点
        TreeNode rootL = new TreeNode(2);
        //把新创建的节点设置为根节点的子节点
        root.setLeftNode(rootL);

        TreeNode rootR = new TreeNode(3);

        root.setRightNode(rootR);

        //为第二层的左节点创建两个节点
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));

        //为第二层的右节点创建两个节点
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        node6.setLeftNode(node5);

        rootR.setLeftNode(node6);
        rootR.setRightNode(new TreeNode(7));

        //把根节点赋给树
        binaryTree.setRoot(root);

        //前序遍历
        binaryTree.frontShow();

        System.out.println("----------------------------");
        //中序遍历
        binaryTree.midShow();

        System.out.println("----------------------------");
        //后序遍历
        binaryTree.afterShow();

        System.out.println("----------------------------");
        //前序查找
        TreeNode result = binaryTree.frontSearch(5);
        System.out.println(result);

        System.out.println("----------------------------");

        //删除一个子树(注意：这是一个子树，也就是说会把其孩子节点也删除)
        binaryTree.delete(5);

        binaryTree.frontShow();


    }
}
