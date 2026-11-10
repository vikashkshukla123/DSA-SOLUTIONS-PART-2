class Solution {
public:
typedef pair<int,int>p;
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        vector<int>requestHandles(k,0);
        set<int>availableServer;
        for(int i = 0; i < k; i++){
            availableServer.insert(i);
        }
        priority_queue<p,vector<p>,greater<p>>busyServers;
        int n = arrival.size();
        for(int i = 0; i < n; i++){
            int arrivalTime = arrival[i];
            int targetServer = (i % k);

            while(!busyServers.empty()){
                pair<int,int>p = busyServers.top();

                int finishTime = p.first;
                int serverNumber = p.second;

                if(finishTime <= arrivalTime){
                    availableServer.insert(serverNumber);
                    busyServers.pop();

                }else{
                    break;
                }
            }

            if(availableServer.empty()) continue;

            auto it = availableServer.lower_bound(targetServer);
            if(it == availableServer.end()){
                it = availableServer.begin();
            }
            int server = *it;

            availableServer.erase(it);
            requestHandles[server]++;

            int busyTime = arrivalTime + load[i];
            busyServers.push({busyTime,server});


        }


        int maxiRequest = -1e9;
        for(int i = 0; i < k; i++){
            maxiRequest = max(maxiRequest, requestHandles[i]);
        }

        vector<int>ans;
        for(int i = 0; i < k; i++){
            if(requestHandles[i] == maxiRequest){
                ans.push_back(i);
            }
        }


        return ans;
        
    }
};