class FreqStack {
    unordered_map<int,int>freq;
    priority_queue<pair<int,pair<int,int>>>pq;
    int pos = 0;
public:
    FreqStack() {
        
    }
    
    void push(int val) {
        pq.push(make_pair(freq[val]++, make_pair(pos,val)));
        pos++;
        
    }
    
    int pop() {
        auto it = pq.top();
        pq.pop();
        int val = it.second.second;
        freq[val]--;

        return val;
        
    }
};

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack* obj = new FreqStack();
 * obj->push(val);
 * int param_2 = obj->pop();
 */