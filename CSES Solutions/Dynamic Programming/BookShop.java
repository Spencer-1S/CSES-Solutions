import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BookShop {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        int[] price=new int[n];
        int[] pages=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            price[i]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            pages[i]=Integer.parseInt(st.nextToken());

        // state: dp[level][money left]=maximum number of pages we can get with 'money left' money
                                    //  if we start out process from index=level

        // Transitions:
        /*
            dp[level][mleft]=max(dp[level+1][mleft], pages[level]+dp[level+1][mleft-price[level]])

         */
        int[][] dp=new int[n+1][x+1];
        // Arrays.stream(dp).forEach(row->Arrays.fill(row, -1));

        // System.out.println(rec(0, x, price, pages, dp));

        for(int level=n-1;level>=0;level--)
        {
            for(int moneyleft=0;moneyleft<=x;moneyleft++)
            {
                int skip=dp[level+1][moneyleft];
                int take=0;
                if(moneyleft-price[level]>=0)
                    take=pages[level]+dp[level+1][moneyleft-price[level]];
                dp[level][moneyleft]=Math.max(take, skip);
            }
        }
        System.out.println(dp[0][x]);
        
    }

    // Recursive implementation
    public static int rec(int level, int moneyleft, int[] price, int[] pages, int[][] dp)
    {
        if(level==price.length)
            return 0;   

        if(dp[level][moneyleft]!=-1)
            return dp[level][moneyleft];
        
        int branch1=rec(level+1, moneyleft, price, pages, dp);
        int branch2=0;

        if(moneyleft-price[level]>=0)
            branch2=pages[level]+rec(level+1, moneyleft-price[level], price, pages, dp);

        int p=Math.max(branch1, branch2);

        return dp[level][moneyleft]=p;

    }
}
