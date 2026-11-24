class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    int dp[][];
    int solve(int row, int col,int [][]matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        if(row < 0 || col < 0 || row >= n || col >= m){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int ans = 1;


        for(int i = 0; i < 4; i++){
            int newr = row + dir[i][0];
            int newc = col + dir[i][1];

            if(newr >= 0 && newc >= 0 && newr < n && newc < m && matrix[newr][newc] > matrix[row][col]){
                ans =  Math.max(ans, 1 + solve(newr,newc,matrix));
                
            }
        }
        return dp[row][col] = ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 1;
        dp = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, solve(i,j,matrix));

            }
        }
        return ans;
        
    }
}