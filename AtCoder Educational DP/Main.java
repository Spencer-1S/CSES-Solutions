import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        FastReader fr=new FastReader();
        int T=1;//fr.nextInt();
        test: while (T-->0)
        {

            int n=fr.nextInt();
            int[] h=fr.readintarray(n);
            int[] dp=new int[n+1];
            // Arrays.fill(dp, -1);

            // System.out.println(rec(0, dp, h));


            //dp[i]=Math.min(abs(h[i]-h[i+1])+dp[i+1], abs(h[i]-h[i+2])+dp[i+2]);

            dp[h.length-1]=0;
            for(int i=h.length-2;i>=0;i--)
            {
                if(i==h.length-2)
                    dp[i]=Math.abs(h[i]-h[i+1]);
                else
                {
                    dp[i]=Math.min(
                        Math.abs(h[i]-h[i+1])+dp[i+1],
                        Math.abs(h[i]-h[i+2])+dp[i+2]
                    );
                }
            }
            System.out.println(dp[0]);
        }
    }

    // Recursive implementation
    static int rec(int index, int[] dp, int[] h)
    {
        if(index>=h.length)
            return Integer.MAX_VALUE;
        if(index==h.length-1)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        return dp[index]=Math.min(
            Math.abs(h[index]-h[index+1])+rec(index+1, dp, h),
            (index!=h.length-2)?Math.abs(h[index]-h[index+2])+rec(index+2, dp, h):Integer.MAX_VALUE);
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