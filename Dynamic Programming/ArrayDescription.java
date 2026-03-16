import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayDescription {
    static int M=(int)1e9+7;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        
        int[] a=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(st.nextToken());

        /*
            dp[level][m] = number of valid arrays from level to n-1 if previous element was m

            Transitions:
            dp[level][m]= dp[level+1][m-1]+dp[level+1][m+1]+dp[level+1][m]
            
        */

        int[][] dp=new int[n+1][m+1];
        // Arrays.stream(dp).forEach(row->Arrays.fill(row, -1));

        // int ans=0;
        // if(a[0]==0)
        // {
        //     for(int x=1;x<=m;x++)
        //         ans=(ans+rec(1, x, dp, a, m))%M;
        // }
        // else
        //     ans=rec(1, a[0], dp, a, m);

        // System.out.println(ans);


        dp[]

    }

    // Recursive implementation
    public static int rec(int level, int prev, int[][] dp, int[] a, int m)
    {
        if(level==a.length)
            return 1;
        if(a[level]!=0)
        {
            if(Math.abs(a[level]-prev)>1)
                return dp[level][prev]=0;
            else
                return dp[level][prev]=rec(level+1, a[level], dp, a, m);

        }
        if(dp[level][prev]!=-1)
            return dp[level][prev];

        int ans=rec(level+1, prev, dp, a, m);

        if(prev-1>=1)
            ans=(ans+rec(level+1, prev-1, dp, a, m))%M;
        if(prev+1<=m)
            ans=(ans+rec(level+1, prev+1, dp, a, m))%M;
        return dp[level][prev]=ans;
    }
}
