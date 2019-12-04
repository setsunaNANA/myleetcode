import java.util.Arrays;
import java.util.Scanner;

public class _209长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null ||nums.length==0) {
            return 0;
        }
        int head=nums.length-1;
        int tail=nums.length-1;
        int min=Integer.MAX_VALUE;
        int sum=nums[head];
        while (head>=0){
            if (sum >=s) {
                min=Math.min(min, tail-head+1);
                if (min == 1) {
                    return 1;
                }
                if (tail>=0) {
                    sum-=nums[tail];
                }
                tail--;
            }
            else {
                head--;
                if (head>=0) {
                    sum+=nums[head];
                }
            }
        }
        if(min==Integer.MAX_VALUE)return 0;
        return min;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len=input.nextInt();
        int [] nums=new int[len] ;
        for (int i = 0; i < len; i++) {
            nums[i]=input.nextInt();
        }
        int sum=input.nextInt();
        input.close();
        _209长度最小的子数组 a=new _209长度最小的子数组();
        System.out.println(a.minSubArrayLen(sum, nums));
    }
}

