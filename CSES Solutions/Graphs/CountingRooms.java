import java.util.*;
import java.io.*;

public class CountingRooms {

    static int[][] dirvec=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args)throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        char[][] grid=new char[n][];
        for(int i=0;i<n;i++)
            grid[i]=br.readLine().toCharArray();
        boolean[][] vis=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='.')
                {
                    if(!vis[i][j])
                    {
                        dfs(i, j, grid, vis);
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
        return;
        
        /* 
        // grid -> adjacency list-> dfs/bfs -> count connected components
        Map<Node, List<Node>> adjlist=new HashMap<>();
        Set<Node> visited=new HashSet<>();
        List<Node> floor=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                var node=new Node(i, j);
                if(grid[i][j]=='.')
                {
                    floor.add(node);
                    if(i+1<n && grid[i+1][j]=='.')
                    {
                        var node2=new Node(i+1, j);
                        if(adjlist.containsKey(node))
                            adjlist.get(node).add(node2);
                        else
                            adjlist.put(node, new ArrayList<Node>(List.of(node2)));
                        if(adjlist.containsKey(node2))
                            adjlist.get(node2).add(node);
                        else
                            adjlist.put(node2, new ArrayList<Node>(List.of(node)));
                    }  
                    if(j+1<m && grid[i][j+1]=='.')
                    {
                        var node2=new Node(i, j+1);
                        if(adjlist.containsKey(node))
                            adjlist.get(node).add(node2);
                        else
                            adjlist.put(node, new ArrayList<Node>(List.of(node2)));
                        if(adjlist.containsKey(node2))
                            adjlist.get(node2).add(node);
                        else
                            adjlist.put(node2, new ArrayList<Node>(List.of(node)));
                    } 
                }
            }
        }

        int cntt=0;
        for(var u:floor)
        {
            if(!visited.contains(u))
            {
                bfs(u, adjlist, visited);
                cntt++;
            }
        }   

        System.out.println(cntt);
        */

    }

    // Iterative DFS (custom stack)
    public static void dfs(int i, int j, char[][] grid, boolean[][] vis)
    {
        ArrayDeque<int[]> stack=new ArrayDeque<>();
        stack.add(new int[]{i,j});
        vis[i][j]=true;
        while(!stack.isEmpty())
        {
            int[] cur=stack.pop();
            for(int[] vector:dirvec)
            {
                int nexti=cur[0]+vector[0];
                int nextj=cur[1]+vector[1];
                if(nexti<grid.length && nextj<grid[0].length && nexti>=0 && nextj>=0)
                {
                    if(!vis[nexti][nextj] && grid[nexti][nextj]=='.')
                    {
                        vis[nexti][nextj]=true;
                        stack.push(new int[]{nexti, nextj});
                    }
                }
            }
        }
    }

    
    public static void bfs(int i, int j, char[][] grid, boolean[][] vis)
    {
        Queue<int[]> queue=new LinkedList<>();
        vis[i][j]=true;
        queue.add(new int[]{i,j});
        while(!queue.isEmpty())
        {
            int[] cur=queue.poll();
            for(int[] vector:dirvec)
            {
                int nexti=cur[0]+vector[0];
                int nextj=cur[1]+vector[1];
                if(nexti<grid.length && nextj<grid[0].length && nexti>=0 && nextj>=0)
                {
                    if(!vis[nexti][nextj] && grid[nexti][nextj]=='.')
                    {
                        vis[nexti][nextj]=true;
                        queue.offer(new int[]{nexti, nextj});
                    }
                }
            }
        }
    }


    public static void bfs(Node vertex, Map<Node, List<Node>> adjlist, Set<Node> visited)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(vertex);
        visited.add(vertex);
        while(!queue.isEmpty())
        {
            Node curnode=queue.poll();
            for(var v:adjlist.getOrDefault(curnode, new ArrayList<>()))
            {
                if(!visited.contains(v))
                {
                    visited.add(v);
                    queue.offer(v);
                }
            }
        }
    }

    public static void dfs(Node vertex, Map<Node, List<Node>> adjlist, Set<Node> visited)
    {
        visited.add(vertex);
        for(var v:adjlist.getOrDefault(vertex, new ArrayList<>()))
        {
            if(!visited.contains(v))
                dfs(v, adjlist, visited);
        }
    }

    static class Node
    {
        int i, j;
        public Node(int i, int j){this.i=i; this.j=j;}

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + i;
            result = prime * result + j;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (i != other.i)
                return false;
            if (j != other.j)
                return false;
            return true;
        }
    }
}
