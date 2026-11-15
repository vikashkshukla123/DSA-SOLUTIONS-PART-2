class Solution {
    int mod = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int []prefixSum = new int[n];
        prefixSum[0] = arr[0];
        int ans = 0;
        for(int i = 1; i < n; i++){
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }
        int prefixOdd = 0;
        int prefixEven = 0;
        for(int i = 0; i < n; i++){
            int currSum = prefixSum[i];

            if(currSum % 2 == 0){
                // Even sum
                ans = (ans + prefixOdd) % mod;
                prefixEven++;
            }else{
                ans = (ans + prefixEven + 1) % mod;
                prefixOdd++;
            }
        }

       return ans;
    }
}