public class _162寻找峰值 {
    public int findPeakElement(int[] nums) {
        int len=nums.length;
        if (len == 1) {
            return 0;
        }
        int left=0;
        int right=len-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]>nums[mid+1]) {
                right=mid;//mid左侧(包括mid)一定有峰值
            }
            else {
                left=mid+1;//mid右侧一定有峰值
            }
        }
        return left;
    }
}
