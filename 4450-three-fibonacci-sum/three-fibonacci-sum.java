class Solution {
    public boolean threeFibonacciSum(int n) {
        int val1 = 0;
        int val2 = 1;
        for(int i = 2; i <= n; i++){
            int newval = val1 + val2;
            if((long)val1 + val2 + newval == n){
                return true;
            }else if((long)val1 + val2 + newval > n){
                return false;
            }
            val1 = val2;
            val2 = newval;
        }
       

return false;
        
    }
}