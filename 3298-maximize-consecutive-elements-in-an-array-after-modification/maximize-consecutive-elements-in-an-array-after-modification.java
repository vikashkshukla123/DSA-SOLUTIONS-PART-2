class Solution {
    int dp[][];
    int find(int i, int val, int []nums){
        int low = i;
        int high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] >= val){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        

        return ans;

        
    }
    int solve(int idx, int inc, int []nums){
        int ans = 1;
        int currVal = nums[idx] + inc;

        if(dp[idx][inc] != -1){
            return dp[idx][inc];
        }

        int idx_ = find(idx + 1, currVal + 1, nums);

        if(idx_ != -1 && nums[idx_] == currVal + 1){
            ans = Math.max(ans, 1 + solve(idx_,0,nums));
        }

        int idx__ = find(idx + 1, currVal,nums);
        if(idx__ != -1 && nums[idx__] == currVal){
            ans = Math.max(ans,1 + solve(idx__, 1, nums));
        }


        return dp[idx][inc] = ans;

        // case1;
    }
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        dp = new int[nums.length][2];
        for(int [] row : dp){
            Arrays.fill(row,-1);
        }
        for(int i = 0; i < nums.length; i++){
            res =  Math.max(res,solve(i,0,nums));
            res = Math.max(res,solve(i,1,nums));

            
        }

        return res;
    }
}