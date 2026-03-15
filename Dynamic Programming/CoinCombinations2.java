import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinCombinations2 {
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

        Arrays.sort(coins);

        // int[][] dp=new int[n+1][x+1];
        // Arrays.stream(dp).forEach(row->Arrays.fill(row, -1));


        // dp transitions:
        // dp[level][sum] = dp[level][sum-coins[level]]+dp[level+1][sum]
        // so dp[level][sum] depends updon next level and a smaller sum
        // so we have to fill level from n-1 to 0 and sum from 0 to x

        // System.out.println(rec(0, dp, coins, x));
        
        // for(int level=0;level<=n;level++)
        //     dp[level][0]=1;

        // dp[level=n][sum>0]=0 // already initialized to 0

        // for(int level=n-1;level>=0;level--)
        // {
        //     for(int sum=1;sum<=x;sum++)
        //     {
                
        //         dp[level][sum]= (  dp[level+1][sum] 
        //                                +
        //                        ((sum-coins[level]>=0)?dp[level][sum-coins[level]]:0))%M;
                               
        //     }
        // }

        
        int[] dp=new int[x+1];
        dp[0]=1;
        for(int c:coins)
        {
            for(int sum=c;sum<=x;sum++)
            {
                dp[sum]=(dp[sum]+dp[sum-c])%M; 
            }
        }
        System.out.println(dp[x]);

    }

    // Recursive implementation
    // rec(level, sumleft)=number of ordered sequence to form sumleft if we start from from level
    public static int rec(int level, int[][] dp, int[] coins, int sumleft)
    {
        if(sumleft<0)
            return 0;
        if(sumleft==0)
            return 1;
        if(level==coins.length)
            return 0;

        if(dp[level][sumleft]!=-1)
            return dp[level][sumleft];

        int pos=0;
        int ways=(rec(level, dp, coins, sumleft-coins[level])+rec(level+1, dp, coins, sumleft))%M;
        pos=(pos+ways)%M;

        return dp[level][sumleft]=pos;
    }

}
