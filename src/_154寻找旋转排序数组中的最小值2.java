public class _154寻找旋转排序数组中的最小值2 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0]<nums[nums.length-1]) {
            return nums[0];
        }

        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            }
            if (nums[left]==nums[mid]) {

            }

            if (nums[left]<nums[mid]) {
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return nums[left];
    }
}
