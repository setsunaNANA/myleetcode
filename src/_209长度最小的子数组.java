import java.util.Arrays;

public class _209长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null ||nums.length==0) {
            return 0;
        }
        int head=nums.length-1;
        int tail=nums.length-1;
        int min=nums.length;
        int sum=nums[head];
        while (head>=0){
            if (sum >=s) {
                min=Math.min(min, tail-head+1);
                if (min == 1) {
                    return 1;
                }
                tail--;
                if (tail>=0) {
                    sum-=nums[tail];
                }

            }
            else {
                head--;
                if (head>=0) {
                    sum+=nums[head];
                }

            }
        }
        return min;
    }

    public static void main(String[] args) {
        _209长度最小的子数组 a=new _209长度最小的子数组();
        System.out.println(a.minSubArrayLen(80, new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8}));
    }
}
