class Solution {
    public int minMergedInteger(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < n; i += 2){
           String s1 = Integer.toString(nums[i]);
           String s2 = Integer.toString(nums[i+1]);

           String s3 = s1.concat(s2);
           int val = Integer.parseInt(s3);

           mini = Math.min(mini,val);
        }


        return mini;
    }
}