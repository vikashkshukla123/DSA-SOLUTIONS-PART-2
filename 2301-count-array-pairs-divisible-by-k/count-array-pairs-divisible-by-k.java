class Solution {
    int gcd(int a, int b){
        if(a < b){
            return gcd(b,a);
        }
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public long countPairs(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer>mp = new HashMap<>();
        long ans = 0;
        for(int i = 0; i < n; i++){
            int gcdNum1 = gcd(nums[i],k);

            for(Map.Entry<Integer,Integer>entry : mp.entrySet()){
                int gcdNum2 = entry.getKey();
                int freq = entry.getValue();


                if(((long) gcdNum1 * gcdNum2) % k == 0){
                    ans += freq;
                }

            }

            mp.put(gcdNum1, mp.getOrDefault(gcdNum1,0) + 1);
        }
        
        return ans;
    }
}