import java.util.Arrays;

public class _16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        int res=0;
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-2 ; i++) {
            while (i > 0 && i <nums.length-2&&nums[i] == nums[i - 1]) i++;
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int d = Math.abs(sum - target);
                if (d < min) {
                    min = d;
                    res=sum;
                    while (low < high&&low!=nums.length-2&&nums[low] == nums[low + 2]) low++;
                    while (low < high&&nums[high] == nums[high - 2]) high--;
                    /*
                    +2 -2而不是+1 -1是因为这里是找最接近的，当前最接近并不代表全局最接近
                    所以不能把这些元素都跳过  low=low+2判断 是为high留一个位置
                    同理 high=high-2 是为给low留一个位置
                     */
                }
                if (sum < target) {
                    low++;
                } else high--;
            }
        }
        return res;
        }

    public static void main(String[] args) {
        _16最接近的三数之和 a=new _16最接近的三数之和();
        int [] nums={13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
        System.out.println(a.threeSumClosest(nums,-59));
    }
}

