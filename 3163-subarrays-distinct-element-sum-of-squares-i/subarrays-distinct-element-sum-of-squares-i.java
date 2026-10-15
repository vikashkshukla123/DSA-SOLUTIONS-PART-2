class Solution {
    int solve(List<Integer>nums, int i, int j){
        Set<Integer>st = new HashSet<>();
        int sum = 0;
        for(int k = i; k <= j; k++){
            if(st.contains(nums.get(k))){
                continue;
            }
            st.add(nums.get(k));

        }

        sum = (st.size() * st.size());
        return sum;
    }
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int calc = solve(nums, i, j);
                ans += calc;
    
            }
        }
        return ans;
    }
}