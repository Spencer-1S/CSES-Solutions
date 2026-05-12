package Algorithms.utils;

import java.util.*;

public class RandomInput {

    Random rand;
    public RandomInput()
    {
        this.rand=new Random();
    }
    
    public int[] intarray(int n)
    {
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=rand.nextInt(1,51);
        return a;
    }
    public int[] intarray(int n, int l, int r)
    {
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=rand.nextInt(l,r+1);
        return a;
    }
    public String[] strarray(int n)
    {
        String[] srr=new String[n];
        for(int i=0;i<n;i++)
        {
            int size=rand.nextInt(1,11);
            StringBuilder s=new StringBuilder();
            for(int j=0;j<size;j++)
                s.append((char)rand.nextInt(97,123));
            srr[i]=s.toString();
        }
        return srr;
    }

    public List<List<Integer>> graph(int n) // n=number of nodes(0 to n-1)
    {
        // graph may have multiple connected components
        List<List<Integer>> adjlist=new ArrayList<>();
        record Edge(int u, int v){}
        Set<Edge> used=new HashSet<>();

        for(int i=0;i<n;i++)
            adjlist.add(new ArrayList<Integer>());
        if(n<=1)
            return adjlist;
        // Total number of edges in a graph = n(n-1)/2
        int nedges=rand.nextInt(1, (n*(n-1))/2+1);
        int i=0;
        while(i<nedges)
        {
            int u=rand.nextInt(0, n);
            int v=rand.nextInt(0, n);
            if(u==v || used.contains(new Edge(u, v)) || used.contains(new Edge(v, u)))
                continue;
            i++;
            used.add(new Edge(u, v));
            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }
        return adjlist;
    }

    public void printGraph(List<List<Integer>> adjlist)
    {
        for(int i=0;i<adjlist.size();i++)
            System.out.println(i+" : %s".formatted(adjlist.get(i).toString()));
    }
}
