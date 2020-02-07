public class _134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int len=gas.length;
        int sum=0;
        int cur_sum=0;
        for (int i =0; i<len ; i++) {
            sum+=gas[i]-cost[i];
            cur_sum+=gas[i]-cost[i];
            if (cur_sum<0) {
                start=i+1;
                cur_sum=0;
            }
        }
        if (sum<0) {
            return -1;
        }
        else return start;
    }
}
