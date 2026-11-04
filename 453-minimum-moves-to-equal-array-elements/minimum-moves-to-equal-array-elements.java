class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            mini = Math.min(nums[i],mini);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += (nums[i] - mini);
        }

        return ans;
        
    }
}