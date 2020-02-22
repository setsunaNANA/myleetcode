public class _189旋转数组 {
    public void rotate(int[] nums, int k) {
        //1 2 3 4 5 6
        //5 6 1 2 3 4
        if (nums.length == 0||(k>=nums.length&&k/nums.length==0)) {
            return;
        }
        k=k%nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    void reverse (int []nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
