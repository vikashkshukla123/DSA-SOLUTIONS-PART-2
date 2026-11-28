class Solution {
    int solve(long n){
        int sum = 0;
        while(n != 0){
            int val =(int) (n % 10);
            sum += val;
            n = n / 10;
        }
        return sum;
    }
    public long makeIntegerBeautiful(long n, int target) {
        int res = solve(n);
        if(res <= target) return 0;
        long mod = 10;
        long ans = 0;
        while(solve(n) > target){
            while(n % mod == 0){
                mod = mod * 10;
            }
            ans = ans + (mod - (n % mod));
            n = n + (mod - (n % mod));

            if(solve(n) <= target){
                return ans;
            }
            
        }
        return -1;
    }
}