public class _215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        return nums[findk(nums, k-1, 0, nums.length-1)];
    }
    int findk(int []nums,int k,int start, int end){
        int head=start;
        int tail=end;
        int axis=nums[start];
        while (head<tail){
            while (head<tail&&nums[tail]<=axis) {
                tail--;
            }
            if (head==tail) {
                break;
            }
            nums[head]=nums[tail];
            head++;
            while (head<tail&&nums[head]>axis) {
                head++;
            }
            if (head==tail) {
                break;
            }
            nums[tail]=nums[head];
            tail--;
        }
        nums[head]=axis;
        if (head == k) {
            return head;
        }
        else if (head<k) {
            return findk(nums, k-head, head+1, end);
        }
        else return findk(nums, k, start, head-1);
    }
    public static void main(String[] args) {
        _215数组中的第K个最大元素 a=new _215数组中的第K个最大元素();
        System.out.println(a.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
// 0 1 2 3 4 5
// 1 2 3 4 5 6
}
