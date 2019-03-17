package 数据结构基础复习.Review_04.线索二叉树;

/**
 * @author RickYinPeng
 * @ClassName BinaryTree
 * @Description 线索二叉树（中序线索二叉树、先序线索二叉树、后序线索二叉树）
 * @date 2019/2/16/12:41
 */
public class BinaryTree {

    //根节点
    TreeNode root;

    //设置根节点
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //获取根节点
    public TreeNode getRoot() {
        return root;
    }

    public void frontShow() {
        if(root!=null){
            root.frontShow();
        }
    }

    public void midShow() {
        if(root!=null) {
            root.midShow();
        }
    }

    public void afterShow() {
        if(root!=null) {
            root.afterShow();
        }
    }

    public TreeNode frontSearch(int i) {
        return root.frontSearch(i);
    }

    public void delete(int i) {
        if(root.value==i){
            root = null;
        }else{
            root.delete(i);
        }
    }

    /**
     * 中序线索化二叉树，就是说，这个二叉树创建好了之后，你掉一下这个方法，这个树就变成了中序线索化二叉树
     */
    public void threadNodes(){
        threadNodes(root);
    }

    //用于临时存储前驱节点
    TreeNode pre = null;

    public void threadNodes(TreeNode node){
        //当前节点如果为null，直接返回
        if(node==null){
            return;
        }
        //处理左子树
        threadNodes(node.leftNode );

        //处理当前节点
        if(node.leftNode==null){
            //让当前节点的左指针指向前驱节点
            node.leftNode = pre;
            //改变当前节点左指针的类型
            node.leftType = 1;

        }
        //处理前驱节点的右指针，如果前驱节点的右指针式null（没有指下右子树）
        if(pre!=null && pre.rightNode==null){
            pre.rightNode = node;
            pre.rightType = 1;
        }

        //每处理一个节点，当前节点使下一个节点的前驱节点
        pre = node;

        //处理右子树
        threadNodes(node.rightNode);
    }

    /**
     * 遍历线索二叉树
     */
    public void threadIterate(){
        //用于临时存储当前遍历节点
        TreeNode node = root;
        while (root!=null){
            //循环找到最开始的节点
            while (node.leftType==0){
                node = node.leftNode;
            }
            //打印当前节点的值
            System.out.println(node.value);

            //如果当前节点的右指针指向的是后继节点，可能后继节点还有后继节点
            while (node.rightType==1){
                node = node.rightNode;
                System.out.println(node.value);
            }

            //替换遍历的节点
            node = node.rightNode;
        }
    }

    /**
     * 中序线索树中找节点的后继
     */
    public TreeNode InNext(TreeNode p){
        TreeNode next = null;
        if(p.rightType==1){
            next = p.rightNode;
        }else {
            TreeNode q;
            if(p.rightNode!=null) {
                for (q = p.rightNode; q.leftType == 0; q = q.leftNode) {
                }
                next = q;
            }
        }
        return next;
    }

    /**
     * 中序线索树中求遍历的第一个节点
     */
    public TreeNode InFirst(TreeNode bt){
        if(bt!=null) {
            TreeNode p = bt;
            if (p == null) {
                return null;
            }
            while (p.leftType == 0) {
                p = p.leftNode;
            }
            return p;
        }
        return null;
    }

    /**
     * 遍历中序线索二叉树
     */
    public void TinOrder(TreeNode root){
        TreeNode p;
        p = InFirst(root);
        while (p!=null){
            System.out.println(p.value);
            p = InNext(p);
        }
    }


}
