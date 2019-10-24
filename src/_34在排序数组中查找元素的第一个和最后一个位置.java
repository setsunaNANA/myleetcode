public class _34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null||nums.length==0) {
            return new int[]{-1,-1};
        }

        int head=0;
        int tail=nums.length-1;
        int mid=(head+tail)/2;
        Boolean flag=false;
        while (head<=tail){
             mid=(head+tail)/2;
            if (nums[mid]==target) {
                flag=true;
                break;
            }
            if (target < nums[mid]) {
                tail=mid-1;
            }
            else {
                head=mid+1;
            }
        }
        if (!flag) {
            return new int[]{-1,-1};
        }
        int head1=0;
        int tail1=mid;
        int  mid1=(head1+tail1)/2;
        while (head1<=tail1){
             mid1=(head1+tail1)/2;
            if (nums[mid1]==target) {
                if (mid1 == 0||nums[mid1-1]!=target) {
                    break;
                }
                else {
                    tail1=mid1-1;
                }
            }
            else {
                head1=mid1+1;
            }
        }

        int head2=mid;
        int tail2=nums.length-1;
        int mid2=(head2+tail2)/2;
        while (head2<=tail2) {
            mid2 = (head2 + tail2) / 2;
            if (nums[mid2] == target) {
                if (mid2 == nums.length - 1 || nums[mid2 + 1] != target) {
                    break;
                } else {
                    head2 = mid2 + 1;
                }
            } else {
                tail2 = mid2 - 1;
            }
        }
            return new int[]{mid1,mid2};
    }

    public static void main(String[] args) {
        _34在排序数组中查找元素的第一个和最后一个位置 a=new _34在排序数组中查找元素的第一个和最后一个位置();
        a.searchRange(new int[]{1,2,3},1);
    }
}
