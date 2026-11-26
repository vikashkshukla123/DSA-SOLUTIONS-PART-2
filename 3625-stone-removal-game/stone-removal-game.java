class Solution {
    public boolean canAliceWin(int n) {
        int start = 10;
        boolean chance = true;
        if(n < start) return false;
        while(true){
            n = n - start;
            if(n < 0){
                break;
            }
            chance = !chance;
            start = start - 1;
        }

        if(!chance) return true;
        return false;

    



    }
}