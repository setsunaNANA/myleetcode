public class _27移除元素 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int count=0;
        for (int i = 0; i <nums.length ; i++) {
            nums[i-count]=nums[i];
            if (nums[i] == val) {
                count++;
            }

        }
        return nums.length-count;
    }
}
