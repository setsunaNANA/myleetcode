public class _45跳跃游戏2 {
    public int jump(int[] nums) {
        if (nums == null||nums.length==0) {
            return -1;
        }
        int curmax=0;
        int premax=0;
        int step=0;
        for (int i = 0; i <nums.length-1; i++) {
            curmax=Math.max(curmax, i+nums[i]);
            if (nums[i] == 0) {
                if (curmax == i) {
                    return -1;
                }
            }
            if (i == premax) {
                step++;
                premax=curmax;
            }
        }
        if (premax > nums.length) {
            return step;
        }
        else  return step+1;
    }
}
