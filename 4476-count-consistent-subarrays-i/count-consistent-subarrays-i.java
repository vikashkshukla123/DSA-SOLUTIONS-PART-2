class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int val = nums[i];
            int mini = val;
            for(int j = i; j < n; j++){
                val = val & nums[j];
                mini = Math.min(mini,nums[j]);

                if(val == mini) cnt++;

            }
        }

        return cnt;
    }
}