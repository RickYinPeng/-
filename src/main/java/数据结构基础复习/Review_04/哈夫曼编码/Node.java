package 数据结构基础复习.Review_04.哈夫曼编码;

/**
 * @author RickYinPeng
 * @ClassName Node
 * @Description
 * @date 2019/2/19/11:51
 */
public class Node implements Comparable<Node>{

    //字节数据（本来是字符，但是字符可以转成字节）
    Byte data;
    //节点的权值
    int weight;
    //左孩子
    Node left;
    //右孩子
    Node right;

    //有的节点（你像叶子节点，他们有字节数据和权值（就是出现次数），他们的父节点就只有权值（子节点权值之和））
    public Node(byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
