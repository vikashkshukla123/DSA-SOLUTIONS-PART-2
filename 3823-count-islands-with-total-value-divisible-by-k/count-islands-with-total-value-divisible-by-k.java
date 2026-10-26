class Solution {
    int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    long bfs(int i, int j, int[][]grid,boolean [][]visited ){
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        long val = 0;
        while(!q.isEmpty()){
            int cell[] = q.poll();
            int row = cell[0];
            int col = cell[1];

            val += (long)grid[row][col];

            for(int i_ = 0; i_ < 4; i_++){
                int newr = row + dir[i_][0];
                int newc = col + dir[i_][1];

                if(newr >= 0 && newr < n && newc >= 0 && newc < m && !visited[newr][newc]&& grid[newr][newc] != 0){
                    q.offer(new int[]{newr,newc});
                    visited[newr][newc] = true;
                }
            } 
        }
return val;

    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean [][]visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    long val = bfs(i,j,grid,visited);
                    if(val % k == 0){
                        ans++;
                    }
                }
            }
        }

        return ans;

        
    }
}