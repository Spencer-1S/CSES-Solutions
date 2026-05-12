package Algorithms.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import Algorithms.utils.RandomInput;

public class IterativeDFS {
    List<Integer> traversal;
    public void dfs(int vertex, List<List<Integer>> adjlist, boolean[] vis)
    {
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(vertex);
        vis[vertex]=true;
        while(!stack.isEmpty())
        {
            int cur=stack.pop();
            traversal.add(cur);
            for(var v:adjlist.get(cur))
            {
                if(!vis[v])
                {
                    stack.push(v);
                    vis[v]=true;
                }
            }
        }
    }

    public void traverse(List<List<Integer>> adjlist)
    {
        traversal=new ArrayList<>();
        boolean[] vis=new boolean[adjlist.size()];
        for(int i=0;i<vis.length;i++)
        {
            if(!vis[i])
                dfs(i, adjlist, vis);
        }
        System.out.println(traversal);
    }


    public static void main(String[] args) {
        RandomInput ri=new RandomInput();
        IterativeDFS idfs=new IterativeDFS();

        var adjlist=ri.graph(10);
        ri.printGraph(adjlist);

        idfs.traverse(adjlist);
    }
}
