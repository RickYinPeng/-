package 数据结构基础复习.Review_04.哈夫曼树;

/**
 * @author RickYinPeng
 * @ClassName Node
 * @Description 哈夫曼树的节点类
 * @date 2019/2/18/16:23
 */
public class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
