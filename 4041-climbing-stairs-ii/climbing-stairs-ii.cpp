class Solution {
public:
int solve(int step, int n, vector<int>&costs,vector<int>&dp){
      if(step == n){
        return 0;
      }

      if(step > n){
        return 1e9;
      }
      if(dp[step] != -1){
        return dp[step];
      }

      int ans = 1e9;
      for(int i = 1; i <= 3; i++){
        int newstep = step + i;

        if(newstep <= n){
            int newcost = costs[newstep - 1] + pow(newstep - step,2);

            ans = min(ans, newcost + solve(newstep, n, costs,dp));
        }
      }

      return dp[step] = ans;
}
    int climbStairs(int n, vector<int>& costs) {
        vector<int>dp(n+2,-1);
        return solve(0,n,costs,dp);
    }
};