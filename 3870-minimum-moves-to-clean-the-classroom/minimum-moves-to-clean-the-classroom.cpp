struct State{
    int row;
    int col;
    int energyVal;
    int litterMaskValue;
};
class Solution {
    vector<vector<int>>dir = {{-1,0},{1,0},{0,1},{0,-1}};
public:
    int minMoves(vector<string>& classroom, int energy) {
        int startingRow = -1;
        int startingCol = -1;
        int n = classroom.size();
        int m = classroom[0].length();

        vector<vector<int>>litterCount(n,vector<int>(m,-1));
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char ch = classroom[i][j];

                if(ch == 'S'){
                    startingRow = i;
                    startingCol = j;
                }else if(ch == 'L'){
                    litterCount[i][j] = cnt;
                    cnt++;
                }
            }
        }


        if(cnt == 0) return 0;

        
        vector<vector<vector<vector<bool>>>>visited(n,vector<vector<vector<bool>>>(m,vector<vector<bool>>(energy + 1,vector<bool>(1 << cnt, false))));
        queue<State>q;
        q.push({startingRow, startingCol, energy, 0});
        visited[startingRow][startingCol][energy][0] = true;
        int moves = 0;
        while(!q.empty()){
            int size = q.size();

            while(size --){
                State curr = q.front();
                q.pop();

                if(curr.litterMaskValue == (1 << cnt) - 1){
                    return moves;
                }


                if(curr.energyVal == 0){
                    continue;
                }

                int r = curr.row;
                int c = curr.col;

                for(int i = 0; i < 4; i++){
                    int newr = r + dir[i][0];
                    int newc = c + dir[i][1];


                    if(newr >= 0 && newr < n && newc >= 0 && newc < m){
                        char nextCell = classroom[newr][newc];
                        if(nextCell == 'X') continue;
                        int nextEnergy = curr.energyVal - 1;
                        int nextMask = curr.litterMaskValue;
                        if(nextCell == 'R'){
                            nextEnergy = energy;
                        }else if(nextCell == 'L'){
                            int maskPos =  litterCount[newr][newc];
                            nextMask  = nextMask | (1 << maskPos);
                        }

                        


                        if(visited[newr][newc][nextEnergy][nextMask] == false){
                            q.push({newr,newc,nextEnergy,nextMask});
                            visited[newr][newc][nextEnergy][nextMask] = true;
                        }
                    }
                }

               

            }
            moves++;


        }


return -1;
        
    }
};