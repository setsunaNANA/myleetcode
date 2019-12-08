public class _81搜索旋转排序数组2 {
    public boolean search(int[] nums, int target) {
        if (nums == null||nums.length==0) {
            return false;
        }
        int start=0;
        int end=nums.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[end]) {
                start++;
                continue;
            }
            if (nums[start]<=nums[mid]) {
                if (target< nums[mid]&&target>=nums[start]) {
                    end=mid-1;
                }
                else {
                    start=mid+1;
                }
            }
            else {
                if (target> nums[mid]&&target<=nums[end]) {
                    start=mid+1;
                }
                else {
                    end=mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _81搜索旋转排序数组2 a=new _81搜索旋转排序数组2();
        System.out.println(a.search(new int[]{1,3,1,1,1}, 3));
    }

}
