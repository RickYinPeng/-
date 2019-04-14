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
}
