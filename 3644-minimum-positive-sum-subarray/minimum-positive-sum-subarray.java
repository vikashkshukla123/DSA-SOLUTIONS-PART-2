class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefixSum = new int[n];
        prefixSum[0] = nums.get(0);
        for(int i = 1; i < n; i++){
            prefixSum[i] = nums.get(i) + prefixSum[i-1];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int len = j - i + 1;
                int sum = prefixSum[j] - (i > 0 ? prefixSum[i-1] : 0);

                if(len >= l && len <= r && sum > 0){
                    ans = Math.min(ans, sum);
                }
            }
        }
        return (ans == Integer.MAX_VALUE ? -1 : ans);
    }
}