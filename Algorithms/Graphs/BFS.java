package Algorithms.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Algorithms.utils.RandomInput;

public class BFS {
    List<Integer> traversal;
    public void traverse(List<List<Integer>> adjlist)
    {
        traversal=new ArrayList<>();
        int n=adjlist.size();
        Queue<Integer> queue=new LinkedList<>();
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++)
        {
            if(!vis[i])
                bfs(i, adjlist, queue, vis);
        }
        System.out.println(traversal);
    }

    public void bfs(int startnode, List<List<Integer>> adjlist, Queue<Integer> queue, boolean[] vis)
    {
        queue.offer(startnode);
        vis[startnode]=true;
        while(!queue.isEmpty())
        {
            int curnode=queue.poll();
            traversal.add(curnode);
            for(int node:adjlist.get(curnode))
            {
                if(!vis[node])
                {
                    queue.offer(node);
                    vis[node]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        RandomInput ri=new RandomInput();
        BFS obj=new BFS();

        var adjlist=ri.graph(10);
        ri.printGraph(adjlist);
        System.out.println("\n");
        obj.traverse(adjlist);
    }
}
