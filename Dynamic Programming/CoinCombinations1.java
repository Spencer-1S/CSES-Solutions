import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinCombinations1 {
    static int M=(int)1e9+7;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] coins=new int[n];
        for(int i=0;i<n;i++)
            coins[i]=Integer.parseInt(st.nextToken());
        long[] dp=new long[x+1];
        
        // transitions:
        // dp[x] = SUMMATION{ dp[x-coin[i]] }

        dp[0]=1;
        for(int sum=1;sum<=x;sum++)
        {
            for(int i=0;i<coins.length;i++)
            {
                if(sum-coins[i]>=0)
                    dp[sum]=dp[sum]+dp[sum-coins[i]];
            }
            dp[sum]%=M;
        }

        System.out.println(dp[x]);
    }


    // Recursive Implementation
    // rec(x) = number of distinct ways to reach a sum of x = dp[x]
    public static int rec(int x, int[] coins, int[] dp)
    {
        if(x<0)
            return 0;
        if(x==0)
            return 1;
        if(dp[x]!=-1)
            return dp[x];

        int pos=0;
        for(int i=0;i<coins.length;i++)
        {
            pos=(pos+rec(x-coins[i], coins, dp))%M;
        }

        return dp[x]=pos;
    }


}
