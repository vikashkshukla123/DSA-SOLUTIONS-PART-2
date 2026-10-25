class Solution {
public:
vector<vector<int>>dir = {{-1,0},{1,0},{0,-1},{0,1}};
bool solve(int i, int j,vector<vector<int>>&grid, vector<vector<bool>>&visited,bool isOnBorder){
    queue<pair<int,int>>q;
    q.push({i,j});
    visited[i][j] = true;
    int n = grid.size();
    int m = grid[0].size();
    while(!q.empty()){
        auto it = q.front();
        q.pop();

        int row = it.first;
        int col = it.second;

        if((row == 0 || col == 0 || row == n-1 || col == m-1) && (grid[row][col] == 0)){
            isOnBorder = true;
        }

        for(int i = 0; i < 4; i++){
            int newr = row + dir[i][0];
            int newc = col + dir[i][1];

            if(newr >= 0 && newr < n && newc >= 0 && newc < m && !visited[newr][newc] && grid[newr][newc] == 0){
                q.push({newr,newc});
                visited[newr][newc] =  true;

            }
        }

    }

    if(!isOnBorder){
        return true;
    }

    return false;
}
    int closedIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>>visited(n,vector<bool>(m,false));
        int island = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == 0){
                    bool isIsland = solve(i,j,grid,visited,false);
                    if(isIsland){
                        island++;
                    }
                }
            }
        }
        return island;
    }
};