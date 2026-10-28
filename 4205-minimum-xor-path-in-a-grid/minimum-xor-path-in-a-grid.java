class Solution {
    int solve(int i,int j, int score, int[][]grid,int[][][] dp ){
        int n = grid.length;
        int m = grid[0].length;

        if(i == n-1 && j == m-1){
            score = score ^ grid[n-1][m-1];
            return score;
        }
        if(dp[i][j][score] != -1){
            return dp[i][j][score];
        }
        int ans = Integer.MAX_VALUE;
        if(i + 1 < n){
            ans = Math.min(ans, solve(i + 1, j, score ^ grid[i][j],grid,dp));  
        }
        if(j + 1 < m){
            ans = Math.min(ans,solve(i,j+1,score ^ grid[i][j],grid,dp));
        }
return dp[i][j][score] = ans;

    }
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][][] dp = new int[n+1][m+1][1025];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                for(int XOR = 0; XOR <= 1024; XOR++){
                    dp[i][j][XOR] = -1;
                }
            }
        }


        return solve(0,0,0,grid,dp);
        
    }
}