class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int month[] = new int[12];

        int ans = 0;
        month[0] = 31;
        month[1] = 28;
        month[2] = 31;
        month[3] = 30;
        month[4] = 31;
        month[5] = 30;
        month[6] = 31;
        month[7] = 31;
        month[8] = 30;
        month[9] = 31;
        month[10] = 30;
        month[11] = 31;
        int aliceArriveMonth = Integer.parseInt(arriveAlice.substring(0,2));
        int aliceArriveDate = Integer.parseInt(arriveAlice.substring(3));
        int bobArriveMonth = Integer.parseInt(arriveBob.substring(0,2));
        int bobArriveDate = Integer.parseInt(arriveBob.substring(3));
        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0,2));
        int aliceLeaveDate = Integer.parseInt(leaveAlice.substring(3));
        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0,2));
        int bobLeaveDate = Integer.parseInt(leaveBob.substring(3));




        int togetherMonth = Math.max(aliceArriveMonth,bobArriveMonth);
        int togetherDate = togetherMonth == aliceArriveMonth ? aliceArriveDate : bobArriveDate;
        int leaveMonth = Math.min(aliceLeaveMonth,bobLeaveMonth);
        int leaveDate = leaveMonth == aliceLeaveMonth ? aliceLeaveDate : bobLeaveDate;

        if(aliceArriveMonth == bobArriveMonth){
            togetherDate = Math.max(aliceArriveDate,bobArriveDate);
        }

        if(aliceLeaveMonth == bobLeaveMonth){
            leaveDate = Math.min(aliceLeaveDate,bobLeaveDate);
        }

        if(leaveMonth < togetherMonth || (leaveMonth == togetherMonth && leaveDate < togetherDate)) return 0;

int sum = 0;
for(int m = togetherMonth; m <= leaveMonth; m++){
    sum += month[m-1];
}

sum -= togetherDate - 1;
sum -= month[leaveMonth - 1] - leaveDate;

return sum; 





       
        
    }
}