package 数据结构基础复习.Review_04.链结构二叉树;

/**
 * @author RickYinPeng
 * @ClassName TreeNode
 * @Description 树的节点对象
 * @date 2019/2/16/12:51
 */
public class TreeNode {
    //节点权
    int value;
    //左儿子
    TreeNode leftNode;

    //右儿子
    TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * 前序遍历
     */
    public void frontShow() {
        //前序遍历
        System.out.println(this.value);
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        if (leftNode != null) {
            leftNode.midShow();
        }
        System.out.println(this.value);
        if (rightNode != null) {
            rightNode.midShow();
        }
    }

    /**
     * 后序遍历
     */
    public void afterShow() {
        if (leftNode != null) {
            leftNode.afterShow();
        }
        if (rightNode != null) {
            rightNode.afterShow();
        }
        System.out.println(this.value);
    }

    /**
     * 前序查找算法
     */
    public TreeNode frontSearch(int i) {
        TreeNode target = null;
        if (this.value == i) {
            return this;
        } else {
            if (leftNode != null) {
                target = leftNode.frontSearch(i);
            }
            if (target != null) {
                return target;
            }
            if (rightNode != null) {
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }

    /**
     * 删除一棵子树
     * 如果左子树和右子树有相同的两个数，那么这种方法会全部删除的
     */
    public void delete(int i) {
        TreeNode parent = this;
        //判断左孩子
        if(parent.leftNode!=null && parent.leftNode.value==i){
            parent.leftNode = null;
            return;
        }
        //判断右孩子
        if(parent.rightNode!=null && parent.rightNode.value==i){
            parent.rightNode = null;
            return;
        }
        //如果都不是
/*        parent = leftNode;
        if(parent!=null){
            parent.delete(i);
        }
        parent = rightNode;
        if(parent!=null){
            parent.delete(i);
        }*/

        if(leftNode!=null){
            leftNode.delete(i);
        }
        if(rightNode!=null){
            rightNode.delete(i);
        }
    }
}
