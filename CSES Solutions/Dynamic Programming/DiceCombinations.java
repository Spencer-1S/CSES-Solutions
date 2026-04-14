import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceCombinations
{
    static int M=(int)1e9+7;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        // dp[sumleft]= number of ways to reach sum=sumleft from current config
        int[] dp=new int[n+5];
        dp[0]=1;

        for(int sum=1;sum<=n;sum++)
        {
            int ways=0;
            for(int i=1;i<=6;i++)
            {
                if(sum-i>=0)
                    ways=(ways+dp[sum-i])%M;
            }
            dp[sum]=ways;
        }

        System.out.println(dp[n]);
    }


    // Recursive implementation
    public static int rec(int sumleft, int[] dp)
    {
        if(sumleft<0)
            return 0;
        if(sumleft==0)
            return 1;

        if(dp[sumleft]!=-1)
            return dp[sumleft];
        
        int pos=0;
        for(int i=1;i<=6;i++)
        {
            pos=(pos+rec(sumleft-i, dp))%M;
        }

        return dp[sumleft]=pos;
    }
}