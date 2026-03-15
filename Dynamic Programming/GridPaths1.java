import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GridPaths1 {

    static int M=(int)1e9+7;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        char[][] grid=new char[n][n];
        for(int i=0;i<n;i++)
        {
            grid[i]=br.readLine().toCharArray();
        }

        int[][] dp=new int[n+1][n+1];

        // state: dp[r][c]=number of ways to reach n-1,n-1 from r,c (following the constraints)
        // transitions:
        // dp[r][c]=dp[r+1][c]+dp[r][c+1]

        // Arrays.stream(dp).forEach(row->Arrays.fill(row, -1));

        // System.out.println(rec(0,0,grid,dp));


        dp[n-1][n-1]=(grid[n-1][n-1]=='*')?0:1;
        for(int r=n-1;r>=0;r--)
        {
            for(int c=n-1;c>=0;c--)
            {
                if(grid[r][c]=='*')
                    dp[r][c]=0;
                else
                {
                    if(r==n-1 && c==n-1)
                        continue;
                    
                    int ways=0;
                    if(r+1<n)
                        ways+=dp[r+1][c];
                    if(c+1<n)
                        ways+=dp[r][c+1];
                    dp[r][c]=ways%M;
                }
                
            }
        }
        System.out.println(dp[0][0]);
    }


    // Recursive implementation
    //rec(r,c)=numer of ways to reach n-1,n-1 from r,c
    public static int rec(int r, int c, char[][] grid, int[][] dp)
    {
        if(r==grid.length || c==grid.length || grid[r][c]=='*')
            return 0;

        if(r==grid.length-1 && c==grid.length-1)
            return 1;

        if(dp[r][c]!=-1)
            return dp[r][c];

        int paths=(rec(r+1, c, grid, dp)+rec(r, c+1, grid, dp))%M;

        return dp[r][c]=paths;

    }
}
