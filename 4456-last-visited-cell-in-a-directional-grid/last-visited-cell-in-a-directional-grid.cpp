class Solution {
public:
    vector<int> lastVisitedCell(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int curr_row = 0;
        int curr_col = 0;
        vector<vector<bool>>visited(n,vector<bool>(m,false));
        visited[curr_row][curr_col] = true;
        
        while(true){
            char dir = grid[curr_row][curr_col];
            if(dir == 'R'){
                int newr = curr_row;
                int newc = curr_col + 1;


                if(newr < 0 || newr >= n || newc < 0 || newc >= m){
                    return {curr_row,curr_col};
                }else if(visited[newr][newc]){
                    return {curr_row,curr_col};
                }else{
                    visited[newr][newc] = true;
                    curr_row = newr;
                    curr_col = newc;
                }

            } else if(dir == 'L'){
                int newr = curr_row;
                int newc = curr_col - 1;


                if(newr < 0 || newr >= n || newc < 0 || newc >= m){
                    return {curr_row,curr_col};
                }else if(visited[newr][newc]){
                    return {curr_row,curr_col};
                }else{
                    visited[newr][newc] = true;
                    curr_row = newr;
                    curr_col = newc;
                }

            }else if(dir == 'U'){
                int newr = curr_row - 1;
                int newc = curr_col;


                if(newr < 0 || newr >= n || newc < 0 || newc >= m){
                    return {curr_row,curr_col};
                }else if(visited[newr][newc]){
                    return {curr_row,curr_col};
                }else{
                    visited[newr][newc] = true;
                    curr_row = newr;
                    curr_col = newc;
                }

            }else {
                int newr = curr_row + 1;
                int newc = curr_col;


                if(newr < 0 || newr >= n || newc < 0 || newc >= m){
                    return {curr_row,curr_col};
                }else if(visited[newr][newc]){
                    return {curr_row,curr_col};
                }else{
                    visited[newr][newc] = true;
                    curr_row = newr;
                    curr_col = newc;
                }
                
            }

        }

        return {-1,-1};

        
    }
};