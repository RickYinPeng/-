package 数据结构基础复习.Review_04.平衡二叉树;

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
     * 返回当前节点的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 获取左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 向子树中添加节点
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

        //查询是否平衡
        //进行右旋转（往右边旋转）
        if (leftHeight() - rightHeight() >= 2) {
            //双旋转
            if (left != null && left.leftHeight() < left.rightHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                //单旋转
                rightRotate();
            }
        }
        if (leftHeight() - rightHeight() <= -2) {
            //双旋转
            if(right!=null && rightHeight()<right.leftHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                //左旋转
                leftRotate();
            }
        }
    }

    /**
     * 左旋转（书上的LL型）
     */
    private void leftRotate() {
        Node newleft = new Node(value);
        newleft.left = left;
        newleft.right = right.left;

        value = right.value;

        right = right.right;

        left = newleft;
    }

    /**
     * 右旋转（书上的RR型）
     */
    private void rightRotate() {
        //创建一个新的节点，值等于当前节点的值
        Node newRight = new Node(value);
        //把新节点的右子树设置为当前节点的右子树
        newRight.right = right;
        //把当新节点的左子树设置为当前
        newRight.left = left.right;

        //把当前节点的值换为左子节点的值
        value = left.value;

        //把当前节点的左子树设置为左子树的左子树
        left = left.left;

        //把当前节点的右子树设置为新节点
        right = newRight;

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
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value && this.left != null) {
            return this.left.search(value);
        } else if (value > this.value && this.right != null) {
            return this.right.search(value);
        } else {
            return null;
        }
    }

    /**
     * 查找当前节点的父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);
            }
        }
        return null;
    }
}
