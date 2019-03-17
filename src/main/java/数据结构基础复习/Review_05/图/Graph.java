package 数据结构基础复习.Review_05.图;

import java.util.Stack;

/**
 * 图结构
 */
public class Graph {
    private Vertex[] vertex;
    private int currentSize = 0;
    public int[][] adjMat;
    private Stack<Integer> stack;
    //当前遍历的下标
    private int currentIndex;

    public Graph(int size) {
        vertex = new Vertex[size];
        adjMat = new int[size][size];
        stack = new Stack<>();
    }

    /**
     * 向图中加入一个顶点
     */
    public void addVertex(Vertex v) {
        vertex[currentSize++] = v;
    }

    public void addEdge(String v1, String v2) {
        int index1 = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(v1)) {
                index1 = i;
                break;
            }
        }
        int index2 = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(v2)) {
                index2 = i;
                break;
            }
        }
        /**
         * 因为是无向图啊
         */
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;
    }

    /**
     * 深度优先搜索算法
     */
    public void DFS() {
        //把第0个顶点标记为已访问的状态
        vertex[0].visited = false;
        //把第0个顶点的下标压入栈中
        stack.push(0);
        //打印顶点的值
        System.out.println(vertex[0].getValue());
        //遍历
        out:
        while (!stack.isEmpty()) {
            for (int i = currentIndex + 1; i < vertex.length; i++) {
                //如果和下一个遍历的元素时通的
                if (adjMat[currentIndex][i] == 1 && vertex[i].visited == false) {
                    //把下一个元素压入栈中
                    stack.push(i);
                    vertex[i].visited = true;
                    System.out.println(vertex[i].getValue());
                    /**
                     * 注意：这里之前就没有搞懂，设置当前下标为下一个
                     */
                    currentIndex = i;
                    continue out;
                }
            }
            stack.pop();
            if (!stack.isEmpty()) {
                currentIndex = stack.peek();
            }
        }
    }
}

