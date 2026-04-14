import java.io.*;
import java.util.*;

public class C
{
    public static void main(String[] args)throws IOException
    {
        FastReader fr=new FastReader();
        int T=1;//fr.nextInt();
        test: while (T-->0)
        {
            int n=fr.nextInt();
            List<int[]> list=new ArrayList<>();
            for(int i=0;i<n;i++)
                list.add(new int[]{fr.nextInt(), fr.nextInt(), fr.nextInt()});
            int[][] dp=new int[n+1][4];

            // Arrays.stream(dp).forEach(row->Arrays.fill(row,-1));

            // System.out.println(rec(0, 3, list, dp));

            // dp[i][j]=max{0<=x<=2 && x!=j}(list.get(i)[x]+dp[i+1][x])
            for(int i=n-1;i>=0;i--)
            {
                for(int j=0;j<3;j++)
                {
                    for(int x=0;x<3;x++)
                    {
                        if(x!=j)
                            dp[i][j]=Math.max(dp[i][j], list.get(i)[x]+dp[i+1][x]);
                    }
                }
            }

            System.out.println(Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2]));

        }
    }
    
    // Recursive implementation
    static int rec(int index, int prev, List<int[]> list, int[][] dp)
    {
        if(index==list.size())
            return 0;
        
        if(dp[index][prev]!=-1)
            return dp[index][prev];
        int happiness=0;
        for(int i=0;i<3;i++)
        {
            if(i!=prev)
                happiness=Math.max(happiness, list.get(index)[i]+rec(index+1, i, list, dp));
        }
        return dp[index][prev]=happiness;
    }
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){br=new BufferedReader(new InputStreamReader(System.in));}
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try{st=new StringTokenizer(br.readLine());}
                catch(IOException E){E.printStackTrace();}
            }
            return st.nextToken();
        }
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        float nextFloat() {return Float.parseFloat(next());}
        double nextDouble() {return Double.parseDouble(next());}

        String nextLine(){
            String s="";
            try{s=br.readLine().trim();}
            catch(IOException E){E.printStackTrace();}
            return s;
        }
        String[] readstringarray(int n){
            String[] res = new String[n];
            for(int i = 0; i<n; i++)res[i] = next();
            return res;
        }
        
        int [] readintarray(int n){
            int res [] = new int [n];
            for(int i=0;i<n;i++)res[i] = nextInt();
            return res;
        }
        
        long [] readlongarray(int n){
            long res [] = new long [n];
            for(int i=0;i<n;i++)res[i] = nextLong();
            return res;
        }
        
        float[] readfloatarray(int n){
            float res[] = new float[n];
            for(int i=0;i<n;i++)res[i] = (float)nextFloat();
            return res;
        }
        
        double[] readdoublearray(int n){
            double res[] = new double[n];
            for(int i=0;i<n;i++)res[i] = (double)nextDouble();
            return res;
        }
    }
}