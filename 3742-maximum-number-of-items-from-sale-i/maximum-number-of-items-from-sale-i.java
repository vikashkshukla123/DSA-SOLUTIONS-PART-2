class Solution {
    int dp[][][];
    int solve(int idx, int[][]items,int buyFirstTime,Map<Integer,Integer>mp, int budget){
        int n = items.length;
        if(idx >= n) return 0;
        if(budget <= 0) return 0;
        if(dp[idx][budget][buyFirstTime] != -1) return dp[idx][budget][buyFirstTime];
        int ans = Integer.MIN_VALUE;
        int case1 = solve(idx + 1, items,1, mp,budget);
        if(items[idx][1] <= budget && buyFirstTime == 1){
            int case2 = 1 + mp.getOrDefault(idx, 0)  + solve(idx,items,0,mp, budget - items[idx][1]);
            ans = Math.max(ans,case2);
        }

        if(items[idx][1] <= budget && buyFirstTime == 0){
            int case3 = 1 + solve(idx,items, 0, mp, budget - items[idx][1]);
            ans = Math.max(ans,case3);
        }


        return dp[idx][budget][buyFirstTime] = Math.max(ans,case1);

    }
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        Map<Integer,Integer>mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            int f1 = items[i][0];
            for(int j = 0; j < n; j++){
                if(j == i) continue;
                int f2 = items[j][0];

                if(f2 % f1 == 0){
                    mp.put(i,mp.getOrDefault(i,0) + 1);
                }
            }
        }
        dp = new int[n+1][budget + 1][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= budget; j++){
                for(int k = 0; k < 2; k++){
                    dp[i][j][k] = -1;
                }
            }
        }



        return solve(0,items,1,mp,budget);
        
    }
}