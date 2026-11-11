class Solution {
public:
typedef pair<long long,int>p;
typedef vector<long long>q;
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        int n = servers.size();
        int m = tasks.size();

        priority_queue<p,vector<p>,greater<p>>freeServer;
        priority_queue<q,vector<q>,greater<q>>occupiedServer;
        for(int i = 0; i < n; i++){
            freeServer.push({1LL*servers[i],i});
        }

        vector<int>ans(m,0);
        for(int i = 0; i < m; i++){
            int timeTillNow = i;
            long long timeToFinishTask = 1LL * (i + tasks[i]);


            while(!occupiedServer.empty()){
                vector<long long>free = occupiedServer.top();

                long long timeHere = 1LL*free[0];
                long long weight = 1LL* free[1];
                int idx = free[2];

                if(timeHere <= timeTillNow){
                    occupiedServer.pop();
                    freeServer.push({weight,idx});
                }else{
                    break;
                }
            }

            if(freeServer.empty()){
                vector<long long>server = occupiedServer.top();
                long long serverFinish = 1LL*server[0];
                long long weight = 1LL * server[1];
                long long idx = 1LL * server[2];
                occupiedServer.pop();
                ans[i] = (int)idx;
                occupiedServer.push({serverFinish + 1LL * tasks[i],weight,idx});
                continue;

            }
            pair<long long,int>server = freeServer.top();
            freeServer.pop();

            int serverIdx = server.second;
            long long weight = 1LL * server.first;

            ans[i] = serverIdx;

            occupiedServer.push({timeToFinishTask,weight,serverIdx});
        }
        return ans;
    }
};