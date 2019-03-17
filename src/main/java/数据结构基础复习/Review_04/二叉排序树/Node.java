package 数据结构基础复习.Review_04.二叉排序树;

/**
 * @author RickYinPeng
 * @ClassName Node
 * @Description
 * @date 2019/2/20/11:45
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 向子树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入的节点的值比当前子树的根节点的值大还是小
        //添加的节点比当前节点的值更小
        if (node.value < this.value) {
            //如果左节点为空
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void midShow(Node node) {
        if (node != null) {
            midShow(node.left);
            System.out.println(node.value);
            midShow(node.right);
        }
    }

    /**
     * 查找节点
     * @param value
     * @return
     */
    public Node search(int value) {
        if(this.value==value){
            return this;
        }else if(value<this.value && this.left!=null){
            return this.left.search(value);
        }else if(value>this.value && this.right!=null){
            return this.right.search(value);
        }else {
            return null;
        }
    }

    /**
     * 查找当前节点的父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if((this.left!=null && this.left.value==value)||(this.right!=null && this.right.value==value)){
            return this;
        }else {
            if(value<this.value && this.left!=null){
                return this.left.searchParent(value);
            }else if(value>this.value && this.right!=null){
                return this.right.searchParent(value);
            }
        }
        return null;
    }
}
