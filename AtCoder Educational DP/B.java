import java.io.*;
import java.util.*;

public class B
{
    public static void main(String[] args)throws IOException
    {
        FastReader fr=new FastReader();
        int T=1;//fr.nextInt();
        test: while (T-->0)
        {

            int n=fr.nextInt();
            int k=fr.nextInt();
            int[] h=fr.readintarray(n);
            int[] dp=new int[n+1];
            // Arrays.fill(dp, -1);

            // System.out.println(rec(0, dp, h, k));


            dp[h.length-1]=0;
            for(int i=h.length-2;i>=0;i--)
            {
                dp[i]=Integer.MAX_VALUE;
                for(int x=1;x<=k && i+x<h.length;x++)
                    dp[i]=Math.min(dp[i], Math.abs(h[i]-h[i+x])+dp[i+x]);
            }
            System.out.println(dp[0]);
        }
    }

    // Recursive implementation
    static int rec(int index, int[] dp, int[] h, int k)
    {
        if(index>=h.length)
            return Integer.MAX_VALUE;
        if(index==h.length-1)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k && index+i<h.length;i++)
        {
            min=Math.min(min, Math.abs(h[index]-h[index+i])+rec(index+i, dp, h, k));
        }
        return dp[index]=min;
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