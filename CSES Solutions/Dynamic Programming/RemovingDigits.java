import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemovingDigits {
    public static void main(String[] args)throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        
        // state=dp(n)=minimum number of ways to make n-> 0 (as asked in the question)

        // transitions:
        // dp(n)=min{ 1+dp(n-d[i])  } where d[i]=digit in n (d[i]!=0 since substracting 0 gives no gain)

        int[] dp=new int[n+1];
        // Arrays.fill(dp, -1);

        // System.out.println(rec(n, dp));


        for(int x=1;x<=n;x++)
        {
            int k=x;
            int min=Integer.MAX_VALUE;
            while(k!=0)
            {
                int d=k%10;
                k/=10;
                if(d==0)
                    continue;
                min=Math.min(min, 1+dp[x-d]);
            }
            dp[x]=min;
        }
        System.out.println(dp[n]);

    }


    // Recursive implementation
    public static int rec(int n, int[] dp)
    {
        if(n==0)
            return 0;

        if(dp[n]!=-1)
            return dp[n];

        int k=n;
        int steps=Integer.MAX_VALUE;
        while(k!=0)
        {
            int d=k%10;
            k/=10;
            if(d==0)
                continue;
            steps=Math.min(steps, 1+rec(n-d, dp));
        }

        return dp[n]=steps;

    }


}
