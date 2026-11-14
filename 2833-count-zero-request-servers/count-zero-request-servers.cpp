class Solution {
public:
    vector<int> countServers(int n, vector<vector<int>>& logs, int x, vector<int>& queries) {
        int m = queries.size();
        sort(logs.begin(),logs.end(),[&](vector<int>&a,vector<int>&b){
            return (a[1] < b[1]);
        });

        vector<vector<int>>queryPreserve;
        for(int i = 0; i < m; i++){
            queryPreserve.push_back({queries[i],i});
        }

        sort(queryPreserve.begin(),queryPreserve.end());
        vector<int>ans(m,0);
        int left = 0;
        int right = 0;
        unordered_map<int,int>timing;
        for(int i = 0; i < m; i++){
            int start = queryPreserve[i][0] - x;
            int end = queryPreserve[i][0];

            while(right < logs.size() && logs[right][1] <= end){
                timing[logs[right][0]]++;

                right++;

            }



            while(left < logs.size() && logs[left][1] < start){
                    timing[logs[left][0]] --;

                    if(timing[logs[left][0]] == 0){
                        timing.erase(logs[left][0]);
                    }

                    left++;
            }



    
            

            int idx = queryPreserve[i][1];
            ans[idx] = n - timing.size();
        }


        return ans;
    }
};