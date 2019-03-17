package 数据结构基础复习.Review_04.二叉排序树;

/**
 * @author RickYinPeng
 * @ClassName BinarySortTree
 * @Description
 * @date 2019/2/20/11:45
 */
public class BinarySortTree {
    Node root;

    /**
     * 向二叉排序树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        //如果是一棵空树
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 二叉排序树的中序遍历
     * 中序遍历出来的二叉排序树，结果正好是从小到大
     */
    public void midShow() {
        if (root != null) {
            root.midShow(root);
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            //找到这个节点
            Node target = search(value);
            if (target == null) {
                return;
            }
            //找到它的父节点
            Node parent = searchParent(value);

            //1、要删除的节点是叶子节点
            if (target.left == null && target.right == null) {
                //要删除的节点是父节点的左子节点
                if (parent.left.value == target.value) {
                    //要删除的节点使父节点的右子节点
                    parent.left=null;
                }else {
                    parent.right=null;
                }
            //2、要删除的节点有两个子节点
            }else if(target.left!=null && target.right!=null){
                //删除右子树中值最小的节点，获取到该结点的值
                int min = deleteMin(target.right);

                //替换目标节点的值
                target.value = min;

            }else {
            //3、要删除的节点有一个左子结点或右子节点
                if(target.left!=null){
                    //要删除的节点使父节点的左子节点
                    if (parent.left.value == target.value) {
                        //要删除的节点使父节点的右子节点
                        parent.left=target.left;
                    }else {
                        parent.right=target.left;
                    }
                }else {
                    //要删除的节点是父节点的左子节点
                    if (parent.left.value == target.value) {
                        //要删除的节点使父节点的右子节点
                        parent.left=target.right;
                    }else {
                        parent.right=target.right;
                    }

                }
            }

        }
    }

    /**
     * 删除一棵树中最小的节点
     * @param node
     * @return
     */
    private int deleteMin(Node node) {
        Node target =node;
        while (target.left!=null){
            target = target.left;
        }
        //删除最小的节点
        delete(target.value);
        return target.value;
    }

    /**
     * 查找父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
}
