class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int countAscending = 0;
        int countDescending = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] == (nums[i-1] + 1) % n) countAscending++;
            if(nums[i-1] == (nums[i] + 1) % n) countDescending++;
        }

        if(countAscending == n-1 && nums[0] == 0) return 0;
        if(countAscending == n-1){
            int left = n - nums[0];
            int right = 1 + nums[n-1] + 1 + 1;
            return Math.min(left,right); 
        }
        if(countDescending == n-1){
            int left = n - nums[n-1] + 1;
            int right = (nums[0] + 1) % n + 1;

            return Math.min(left,right);
            
        }

        return -1;
    }
}