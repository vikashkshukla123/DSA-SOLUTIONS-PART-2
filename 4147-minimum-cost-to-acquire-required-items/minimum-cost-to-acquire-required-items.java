class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long case1 = Math.max(need1,need2);

        long costCase1 = costBoth * case1;

        long costCase2 = (long)need1 * cost1 + (long)need2 * cost2;


        long minCosts = Math.min(cost1 + cost2,costBoth);
        long minNeed = Math.min(need1,need2);

        long costCase31 = minCosts * minNeed;

        long remainingQuantity = Math.max(need1,need2) - minNeed;

        costCase31 += remainingQuantity * (need1 >= need2 ? cost1 : cost2);




        



        return Math.min(costCase1,Math.min(costCase2,costCase31));

        


    }
}