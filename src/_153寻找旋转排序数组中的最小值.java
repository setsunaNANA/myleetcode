public class _153寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        if (nums[0]<nums[nums.length-1]) {
            return nums[0];
        }//检查是不是未旋转数组

        int left=0;
        int right=nums.length-1;
        while (left<right){
            while (nums[left]==nums[right]&&left<right){
                right--;
            }//去重
            if (nums[left]<nums[right]) {
                return nums[left];
            }//去重后检查left到right是不是未旋转数组
            int mid=left+(right-left)/2;
            if (nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            }
            if (nums[left]<=nums[mid]) {
                left=mid+1;
            }
            else {
                right=mid;
            }
        }
        return nums[left];
    }
}
