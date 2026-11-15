class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int longest[] = new int[n];
        int shortest[] = new int[n];
        longest[0] = 1;
        shortest[0] = 1;
        int ans = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                longest[i] = 1 + longest[i-1];
                shortest[i] = 1;
                ans = Math.max(ans,longest[i]);
            }else if(nums[i] < nums[i-1]){
                shortest[i] = 1 + shortest[i-1];
                longest[i] = 1;
                ans = Math.max(ans,shortest[i]);
            }else{
                longest[i] = 1;
                shortest[i] = 1;
                ans = Math.max(ans,longest[i]);
                ans = Math.max(ans,shortest[i]);

            }
        }

        return ans;
    }
}