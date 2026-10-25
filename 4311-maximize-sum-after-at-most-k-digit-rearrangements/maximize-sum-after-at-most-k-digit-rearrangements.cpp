class Solution {
public:
    long long maximizeSum(vector<int>& nums, int k) {
        int n = nums.size();
        vector<pair<int,int>>p;
        for(int i = 0; i < n; i++){
            string s = to_string(nums[i]);
            sort(s.rbegin(),s.rend());
            int value = stoi(s);

            int diff = abs(nums[i] - value);
            p.push_back({diff,i});

        }
        sort(p.begin(),p.end(),[&](pair<int,int>&a, pair<int,int>&b){
            int diff1 = a.first;
            int diff2 = b.first;


            return diff1 > diff2;

        });


        long long sum = 0;
        for(int i = 0; i < n; i++){
            if(k > 0){
                long long res = p[i].first + nums[p[i].second];
                sum += res;
                k--;
            }else{
                long long res = nums[p[i].second];
                sum += res;
            }
        }

return sum;
    }
};