class Solution {
    int []check(int k, Map<Integer,Integer>mp2, int[]nums){
        
       List<Integer>ls = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int ele1 = nums[i];
            int A = ele1 + k;
            int B = A + k;
            
            if(mp2.containsKey(ele1) && mp2.get(ele1) > 0 && mp2.containsKey(B) && mp2.get(B) > 0){
                ls.add(A);
                mp2.put(ele1,mp2.get(ele1) - 1);
                mp2.put(B,mp2.get(B) - 1);

            }
        }

          if (ls.size() != nums.length / 2) {
        return new int[0];
    }

    return ls.stream().mapToInt(Integer::intValue).toArray();

    }
    public int[] recoverArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int []doubleDiffArrays = new int[n];
        Map<Integer,Integer>mp1 = new HashMap<>();
        for(int i = 0; i < n; i++){
            doubleDiffArrays[i] = nums[i] - nums[0];
            mp1.put(nums[i],mp1.getOrDefault(nums[i],0) + 1);

        }
        int res[] = new int[n/2];
        for(int i = 0; i < n; i++){
            int k = doubleDiffArrays[i] / 2;
            if(k <= 0) continue;
            Map<Integer,Integer>mp2 = new HashMap<>(mp1);
            
            int []ans = check(k,mp2,nums);

            if(ans.length == 0) continue;

            res = ans;
            break; 
        }


return res;


        
    }
}