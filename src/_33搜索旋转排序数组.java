public class _33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int head=0;
        int tail=nums.length-1;

        while (head<=tail){
            int mid=(head+tail)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[head] <=nums[mid]) {
                if (nums[head]<=target&&target<=nums[mid]) {
                    tail=mid;
                }
                else head=mid+1;
            }
            else {
                if (nums[mid]<=target&& target<=nums[tail]) {
                    head=mid;
                }
                else {
                    tail=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _33搜索旋转排序数组 a=new _33搜索旋转排序数组();
        System.out.println(a.search(new int[]{1,3}, 2));
    }

}
