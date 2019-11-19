public class _238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int []res=new int[nums.length];
        int left=1;
        int right=1;
        for (int i = 0; i <nums.length ; i++) {
            res[i]=left;
            left=left*nums[i];
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            res[i]=right*res[i];
            right=right*nums[i];
        }
        return res;
    }
}
