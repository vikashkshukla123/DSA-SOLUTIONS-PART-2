class Solution {
    int mod = 1000000007;
    int solve(int i, int j, int fromLeft, int [][]grid,int [][][] dp){
        int n = grid.length;
        int m = grid[0].length;

        if(i == n || j == m) return 0;
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(dp[i][j][fromLeft] != -1){
            return dp[i][j][fromLeft];
        }
        int total = 0;
        if(grid[i][j] == 0){
            total = (total + solve(i,j+1,1,grid,dp)) % mod;
            total = (total + solve(i+1,j,0,grid,dp)) % mod;

        }else{
            if(fromLeft == 1){
                total = (total + solve(i+1,j,0,grid,dp)) % mod;
            }else{
                total = (total + solve(i,j+1,1,grid,dp)) % mod;
            }

        }
return dp[i][j][fromLeft] = total;


    }
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][][] dp = new int[n][m][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }


        return solve(0,0,1,grid,dp);


        
    }
}