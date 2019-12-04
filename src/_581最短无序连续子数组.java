import java.util.Scanner;

public class _581最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= nums.length; j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }
                if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
                    continue;
                int k = 0;
                while (k < i && prev <= nums[k]) {
                    prev = nums[k];
                    k++;
                }
                if (k != i)
                    continue;
                k = j;
                while (k < nums.length && prev <= nums[k]) {
                    prev = nums[k];
                    k++;
                }
                if (k == nums.length) {
                    res = Math.min(res, j - i);

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len=input.nextInt();
        int [] nums=new int[len] ;
        for (int i = 0; i < len; i++) {
            nums[i]=input.nextInt();
        }
        input.close();
        _581最短无序连续子数组 a=new _581最短无序连续子数组();
        System.out.println(a.findUnsortedSubarray(nums));
    }
}
