import java.util.*;
import java.io.*;
public class D
{
    public static void main(String[] args)throws IOException
    {
        FastReader fr=new FastReader();
        int T=1;//fr.nextInt();
        test: while (T-->0)
        {
            int n=fr.nextInt();
            int w=fr.nextInt();
            int[][] item=new int[n][2];
            for(int i=0;i<n;i++)
            {
                item[i][0]=fr.nextInt();
                item[i][1]=fr.nextInt();
            }

            long[][] dp=new long[n+1][w+1];

            //dp[i][w]=max(vi+dp[i+1][w-wi], dp[i+1][w])

            for(int i=n-1;i>=0;i--)
            {
                for(int j=w;j>=0;j--)
                    dp[i][j]=Math.max((j-item[i][0]>=0)?item[i][1]+dp[i+1][j-item[i][0]]:0, dp[i+1][j]);
            }

            System.out.println(dp[0][w]);

        }
    }
    
    // Recursive implementation
    // static int rec(int index, int)
    
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