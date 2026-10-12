class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        int[] primes = new int[n+1];
        for(int i = 2; i <= n; i++){
            primes[i] = 1;
        }
        for(int i = 2; i * i <= n; i++){
            if(primes[i] == 1){
                for(int j = i * 2; j <= n; j += i){
                    primes[j] = 0;
                }
            }
        }

        List<Integer>primeActual = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(primes[i] == 1){
                primeActual.add(i);
            }
        }

        int m = primeActual.size();
        List<Integer>ans = new ArrayList<>();
        int currSum = 0;
        if(s < 2) return ans;
        int idx = 0;
        while(idx < m  && currSum < s){
            currSum += primeActual.get(idx);
            ans.add(primeActual.get(idx));
            idx++;
            

        }
        if(currSum > s){
            ans.removeLast();
        }








return ans;

    }
}