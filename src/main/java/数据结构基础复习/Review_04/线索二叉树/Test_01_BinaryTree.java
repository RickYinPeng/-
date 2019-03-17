package 数据结构基础复习.Review_04.线索二叉树;

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
        TreeNode node4 = new TreeNode(4);
        node4.setRightNode(new TreeNode(9));
        rootL.setLeftNode(node4);
        rootL.setRightNode(new TreeNode(5));

        //为第二层的右节点创建两个节点
        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));

        //把根节点赋给树
        binaryTree.setRoot(root);

        //中序遍历
        binaryTree.midShow();
        System.out.println("----------------------");
        binaryTree.threadNodes();
        System.out.println("----------------------");
        binaryTree.TinOrder(root);
        System.out.println("----------------------");

        /*binaryTree.threadIterate();
        System.out.println("----------------------");*/

    }

}
