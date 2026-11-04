class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
         Arrays.sort(nums);
         int middle = nums[n / 2];
         int ans = 0;
         for(int i = 0; i < n; i++){
            ans += Math.abs(nums[i] - middle);
         }
         return ans;
        
    }
}