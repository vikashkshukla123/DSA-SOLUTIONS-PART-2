class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        int n = arr1.length;
        int m = arr2.length;

        for(int i = 0; i < n; i++){
            boolean correct = true;
            for(int j = 0; j < m; j++){
                int dist = Math.abs(arr1[i] - arr2[j]);
                if(dist <= d){
                    correct = false;
                    break;
                }
            }

            if(correct){
                ans++;
            }
        }

        return ans;
        
    }
}