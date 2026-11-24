class Encrypter {
    Map<Character,String>mp1;
    Map<String,Integer>mp2;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        mp1 = new HashMap<>();
        mp2 = new HashMap<>();
        int n = values.length;
        for(int i = 0; i < n; i++){
            char ch = keys[i];
            String value = values[i];
            mp1.put(ch,value);
        }

        int m = dictionary.length;
        for(int i = 0; i < m; i++){
            String s = dictionary[i];
            boolean valid = true;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                char ch = s.charAt(j);

                boolean present = mp1.containsKey(ch);
                if(!present) {
                    valid = false;
                    break;
                }
                String val = mp1.get(ch);
                sb.append(val);
            }
            if(valid){
            mp2.put(sb.toString(),mp2.getOrDefault(sb.toString(),0) + 1);
            }
        }
        
    }
    
    public String encrypt(String word1) {
           int m = word1.length();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < m; j++){
                char ch = word1.charAt(j);

                boolean present = mp1.containsKey(ch);
                if(!present) return "";
                String val = mp1.get(ch);
                sb.append(val);
            }
            
            return sb.toString();
        
    }
    
    public int decrypt(String word2) {
        boolean present = mp2.containsKey(word2);
        if(!present) return 0;
        return (mp2.get(word2));
        
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */