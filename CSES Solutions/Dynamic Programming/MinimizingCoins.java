import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimizingCoins {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int[] coins=new int[n];
        for(int i=0;i<n;i++)
            coins[i]=Integer.parseInt(st.nextToken());

        // dp[x]=minimum number of coins to make sum x

        int[] dp=new int[x+5];
        dp[0]=0;
        for(int sum=1;sum<=x;sum++)
        {
            dp[sum]=(int)1e9;
            for(int i=0;i<coins.length;i++)
            {
                if(sum-coins[i]>=0)
                    dp[sum]=Math.min(dp[sum], dp[sum-coins[i]]+1);
            }
        }

        System.out.println(dp[x]>=(1e9)?-1:dp[x]);

    }


    // Recursive implementation
    public static int rec(int sumleft, int[] coins, int[] dp)
    {
        if(sumleft<0)
            return -2; // means not possible

        if(sumleft==0)
            return 0; // means possible

        if(dp[sumleft]!=-1)
            return dp[sumleft];

        int mincoins=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++)
        {
            int branch=rec(sumleft-coins[i], coins, dp);
            if(branch!=-2)
                mincoins=Math.min(mincoins, 1+branch);
        }

        return dp[sumleft]=mincoins==Integer.MAX_VALUE?-2:mincoins;
    }
}
