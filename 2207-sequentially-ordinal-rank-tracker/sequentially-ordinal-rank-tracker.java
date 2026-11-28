class SORTracker {
    TreeMap<Integer,List<String>>mp;
    int counter;

    public SORTracker() {
        mp = new TreeMap<>((a,b)->Integer.compare(b,a));
        counter = 1;
        
    }
    
    public void add(String name, int score) {
        mp.putIfAbsent(score,new ArrayList<>());
        List<String>str = mp.get(score);
        int idx = Collections.binarySearch(str,name);
        if(idx < 0){
            idx = -(idx + 1);
        }
        str.add(idx,name);
        mp.put(score,str);
  
    }
    
    public String get() {
        int pos = counter;
        String ans = "";
        for(Map.Entry<Integer,List<String>>entry : mp.entrySet()){
            List<String>values = entry.getValue();
            if(values.size() < pos){
                pos = pos - values.size();
                continue;
            }

            ans = values.get(pos-1);
            counter++;
            break;



        }
return ans;
        
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */