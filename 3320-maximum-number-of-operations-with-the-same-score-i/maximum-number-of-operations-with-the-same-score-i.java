class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int sumMax = nums[0] + nums[1];
        if(n == 2) return 1;

        int idx = 2;
        int ops = 1;
        while(idx + 1 < n){
            int sum = nums[idx] + nums[idx + 1];
            if(sum != sumMax){
                break;
            }
            ops++;
            idx = idx + 2;
        }
        return ops;
        
    }
}