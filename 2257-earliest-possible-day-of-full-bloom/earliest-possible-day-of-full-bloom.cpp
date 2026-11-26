class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        vector<pair<int,int>>p;
        int n = plantTime.size();
        for(int i = 0; i < n; i++){
            p.push_back({plantTime[i],growTime[i]});
        }

        sort(p.begin(),p.end(),[&](pair<int,int>&a, pair<int,int>&b){
            return (a.second > b.second);
        });

        int maxiDaysTillNow = p[0].first + p[0].second;
        int prevPlantDay = p[0].first;
        for(int i = 1; i < n; i++){
            int secondPlantDay = prevPlantDay + p[i].first;
            if(secondPlantDay + p[i].second > maxiDaysTillNow){
                maxiDaysTillNow = secondPlantDay + p[i].second;
            }

            prevPlantDay = secondPlantDay;


        }
        return maxiDaysTillNow;

        
    }
};