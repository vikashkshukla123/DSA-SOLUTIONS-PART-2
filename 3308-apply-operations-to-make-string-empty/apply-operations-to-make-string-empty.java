class Solution {
    public String lastNonEmptyString(String s) {
        
        int[]lastOccurence = new int[26];
        for(int i = 0; i < 26; i++){
            lastOccurence[i] = -1;
        }
        int n = s.length();
        for(int i = n-1; i >= 0; i--){
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if(lastOccurence[idx] == -1){
                lastOccurence[idx] = i;
            }
        }

        Map<Character,Integer>mp = new HashMap<>();
        int maxi = Integer.MIN_VALUE;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0) + 1);
            maxi = Math.max(maxi,mp.get(ch));

        }

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(mp.get(ch) == maxi && lastOccurence[ch - 'a'] == i){
                sb.append(ch);

            }
        }


       

return (sb.toString());

        
    }
}