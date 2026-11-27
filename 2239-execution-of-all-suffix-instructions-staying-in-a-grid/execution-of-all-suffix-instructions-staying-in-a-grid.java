class Solution {
    int solve(int n, int []startPos, int s_pos, String s){
        int cnt = 0;
        int currRow = startPos[0];
        int currCol = startPos[1];
        while(true){
            if(s_pos >= s.length()){
                break;
            }
            char next = s.charAt(s_pos);

            if(next == 'L'){
                currCol = currCol - 1;
            }else if(next == 'R'){
                currCol = currCol + 1;
            }else if(next == 'U'){
                currRow = currRow - 1;
            }else{
                currRow = currRow + 1;
            }

            if(currRow < 0 || currRow >= n || currCol < 0 || currCol >= n){
                break;
            }

            
            s_pos++;
            cnt++;

        }

        return cnt;
    }
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[]ans = new int[m];
        for(int i = 0; i < m; i++){
            int cntPos = solve(n,startPos, i,s);
            ans[i] = cntPos;
        }

        return ans;
    }
}