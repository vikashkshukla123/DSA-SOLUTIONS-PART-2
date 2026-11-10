class Solution {
public:
bool checkIsolation(int row_cell, int col_cell, vector<vector<int>>&grid){
    int n = grid.size();
    int m = grid[0].size();

    for(int col = 0; col < m; col++){
        if(col == col_cell) continue;
        if(grid[row_cell][col] == 1) return false;
    }

    for(int row = 0; row < n; row++){
        if(row == row_cell) continue;
        if(grid[row][col_cell] == 1) return false;
    }


    return true;
}
    int countServers(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int totalServer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    totalServer++;
                }
            }
        }

        int isolatedServer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    bool isolated = checkIsolation(i,j,grid);
                    if(isolated){
                        isolatedServer++;
                    }
                }
            }
        }

        return totalServer - isolatedServer;
    }
};