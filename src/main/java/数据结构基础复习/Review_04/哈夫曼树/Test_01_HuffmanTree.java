package 数据结构基础复习.Review_04.哈夫曼树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RickYinPeng
 * @ClassName Test_01_HuffmanTree
 * @Description
 * @date 2019/2/18/16:24
 */
public class Test_01_HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {3,7,8,29,5,11,23,14};
        Node huffmanTree = createHuffmanTree(arr);
        System.out.println(huffmanTree);
    }

    /**
     * 创建哈弗慢树
     * @param arr  二叉树集合
     * @return
     */
    public static Node createHuffmanTree(int[] arr){
        //先使用数组中所有元素创建若干个二叉树（只有一个节点）
        List<Node> nodes = new ArrayList<>();
        for(int valeu:arr){
            nodes.add(new Node(valeu));
        }

        //循环处理，结束条件：集合中只有一个节点
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);

            //取出权值最小的两个二叉树
            //权值最小的
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            //创建一棵新的二叉树
            Node parent = new Node(left.value+right.value);
            parent.left = left;
            parent.right = right;

            //把取出来的两个二叉树移除
            nodes.remove(left);
            nodes.remove(right);
            //放入原来的二叉树即可中
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
