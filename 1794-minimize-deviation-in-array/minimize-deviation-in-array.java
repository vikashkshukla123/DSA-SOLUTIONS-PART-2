class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        TreeSet<Integer>ts = new TreeSet<>();
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 0){
                ts.add(nums[i]);
            }else{
                ts.add(nums[i] * 2);
            }
        }

        int currentDifference = Integer.MAX_VALUE;
        while(true){
            int mini = ts.first();
            int maxi = ts.last();

            int diff = maxi - mini;
            if(diff < currentDifference){
                currentDifference = diff;
            }
            if(maxi % 2 == 0){
                ts.pollLast();
                maxi = maxi / 2;
                ts.add(maxi);
            }else{
                break;
            }
        }
        return currentDifference;
    }
}