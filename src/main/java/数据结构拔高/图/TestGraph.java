package 数据结构拔高.图;

/**
 * @author RickYinPeng
 * @ClassName TestGraph
 * @Description
 * @date 2019/4/14/22:36
 */
public class TestGraph {
     static  Object obj = new Object();
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.dfs(0,0);
    }
}
