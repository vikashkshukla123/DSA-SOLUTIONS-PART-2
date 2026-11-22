class Solution {
    int dp[][];
    int solve(int point,int lane, int []obstacles){
        int n = obstacles.length;
        if(point + 1 >= n) return 0;
        if(dp[point][lane] != -1){
            return dp[point][lane];
        }
        
        int ans = Integer.MAX_VALUE;
        if(obstacles[point + 1] != lane){
            ans = Math.min(ans, 0 + solve(point + 1, lane, obstacles));
        }else {
           for(int nextLane = 1; nextLane <= 3; nextLane++){
            if(nextLane != lane && obstacles[point] != nextLane){
                int res = solve(point, nextLane, obstacles);

                if(res != Integer.MAX_VALUE){
                    ans = Math.min(ans, 1 + res);
                }
            }
           }

        }

        return dp[point][lane] = ans;

    }
    public int minSideJumps(int[] obstacles) {
       dp = new int[obstacles.length + 2][4];
       for(int []row : dp){
        Arrays.fill(row,-1);
       }
        return solve(0,2,obstacles);
    }
}