public class _35搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length==0) {
            return 0;
        }
        int len=nums.length;
        int start=0;
        int end=len-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            System.out.println(start+" "+mid+" "+end);
            System.out.println(nums[start]+" "+nums[mid]+" "+nums[end]);
            if (nums[mid]== target) {
                return mid;
            }
            if (nums[mid] >target) {
                if (mid == 0) {
                    return mid;
                }
                if (nums[mid-1]<target ) {
                    return mid;
                }
                else {
                    end=mid-1;
                }
            }
            else {
                if (mid == len-1) {
                    return mid+1;
                }
                if (nums[mid+1]>target ) {
                    return mid+1;
                }
                else {
                    start=mid+1;
                }
            }
        }
        return 0;
    }
}
