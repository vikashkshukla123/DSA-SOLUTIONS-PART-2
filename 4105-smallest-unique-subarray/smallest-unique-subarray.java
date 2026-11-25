class Solution {
    int power(int a, int b){
        if(b == 0){
            return 1;
        }

        int res = power(a, b/2);
        res = res * res;
        if(b % 2 == 1){
            res *= a;
        }


        return res;
    }
    boolean isPossible(int size, int []nums, int base){
        int toMinus = (int)power(base,size);
        int n = nums.length;
        Map<Integer,Integer>mp = new HashMap<>();
        int left = 0;
        int right = 0;
        int val = 0;
        while(right < n){
            val = (val * base) + nums[right];

            while(left < n && right - left + 1 > size){
                val = val - (nums[left] * toMinus);
                left++;

            }

            if(right - left + 1 == size){
                mp.put(val,mp.getOrDefault(val,0) + 1);
            }

            right++;

        

        }
        for(Map.Entry<Integer,Integer>entry : mp.entrySet()){
            if(entry.getValue() == 1){
                return true;
            }
        }


        return false;
    }
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int base = 0;
        for(int i = 0; i < n; i++){
            base = Math.max(base,nums[i]);
        }
        base = base + 1;
        int low = 1;
        int high = n;
        int result = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(mid,nums,base)){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
}