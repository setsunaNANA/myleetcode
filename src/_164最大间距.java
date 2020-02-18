import java.util.Arrays;


public class _164最大间距 {
    public int maximumGap(int[] nums) {

        int len=nums.length;
        if (len <2) {
            return 0;
        }

        int gap=Integer.MIN_VALUE;
        int min=nums[0];
        int max=nums[0];
        for (int i:nums
             ) {
            min=Math.min(min, i);
            max=Math.max(max, i);
        }
        System.out.println(min+" "+max);
        if (max == min) {
            return 0;
        }
        int interval=(int) Math.ceil((double) (max-min)/(len-1));
        int min_arr[]=new int[len];
        int max_arr[]=new int[len];
        Arrays.fill(min_arr, Integer.MAX_VALUE);
        Arrays.fill(max_arr, Integer.MIN_VALUE);
        for (int i:nums
        ) {
            int index=(i-min)/interval;
            min_arr[index]=Math.min(min_arr[index], i);
            max_arr[index]=Math.max(max_arr[index], i);
        }

        int start=0;

        int end=start+1;

        while (end!=len){
            end=start+1;
            while(end<len&&min_arr[end] == Integer.MAX_VALUE){
                end++;
            }
            if (end == len) {
                return gap;
            }
            gap=Math.max(min_arr[end]-max_arr[start],gap);
            start=end;
        }
        return gap;
    }
}
