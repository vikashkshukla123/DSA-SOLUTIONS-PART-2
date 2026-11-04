class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& locked, int k) {
        int n = nums.size();
        int ans = 0;
        int locking = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j <  n - i - 1; j++){
                if(locked[j] == 0 && locked[j+1] == 0 && nums[j] > nums[j+1]){
                    swap(nums[j],nums[j+1]);
                    ans++;
                    continue;
                }
                if(locked[j] == 1 && nums[j] > nums[j+1]){
                    locked[j] = 0;
                    ans++;
                    locking++;
                }
                if(locked[j+1] == 1 && nums[j] > nums[j+1]){
                    locked[j+1] = 0;
                    locking++;
                    ans++;
                }

                if(nums[j] > nums[j+1] &&  locked[j] == 0 && locked[j+1] == 0){
                    swap(nums[j],nums[j+1]);
                    ans++;
                }


            }
        }
        if(locking > k) return -1;
        return ans;
    }
};