package 数据结构拔高.图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RickYinPeng
 * @ClassName Graph
 * @Description 无向图
 * @date 2019/4/14/22:03
 */
public class Graph {
    //定点个数
    private int v;

    //邻接表
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i= 0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
        Integer i = Integer.valueOf(10);
    }

    //无向图一条边存两次
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }

    //广度优先搜索算法
    public void bfs(int s,int t){
        if(s==t){
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] pre = new int[v];
        for(int i = 0;i<pre.length;i++){
            pre[i] = -1;
        }
        while (queue.size()!=0){
            int w = queue.poll();
            for(int i = 0;i<adj[w].size();i++){
                int q = adj[w].get(i);
                if(!visited[q]){

                    //当我们需要搜索某个节点时，使用这段代码
                    pre[q] = w;
                    if(q==t){
                        print(pre,s,t);
                        return;
                    }
                    //当我们遍历时，直接使用打印即可
                    /*
                    System.out.print(q+"-->");
                    */
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }
    private void print(int[] pre, int s, int t) {
        if(pre[t]!=-1 && t!=s){
            print(pre,s,pre[t]);
        }
        System.out.print(t+"-->");
    }

    /**
     * 全局变量或者类成员变量，当我们已经找到终止顶点t之后，我们就不需要再递归的继续找了
     */
    boolean found = false;

    /**
     * DFS深度优先搜索
     * @param s
     * @param t
     */
    public void dfs(int s,int t){
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for(int i =0;i<v;i++){
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);
        //print(prev,s,t);

    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if(found==true){
            return;
        }
        visited[w] = true;
        /*if(w==t){
            found = true;
            return;
        }*/
        for(int i = 0;i<adj[w].size();i++){
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q] = w;
                System.out.println(q);
                recurDfs(q,t,visited,prev);
            }
        }
    }
}
