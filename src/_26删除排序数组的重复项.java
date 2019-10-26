public class _26删除排序数组的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0||nums==null) {
            return 0;
        }
        int cur=nums[0];
        int k=0;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]==cur) {
                k++;
            }
            else cur=nums[i];
            nums[i-k]=nums[i];
        }
        return nums.length-k;
    }
}
