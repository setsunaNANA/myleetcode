import java.util.HashSet;
import java.util.Set;

public class _219存在重复元素2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null||nums.length==0) {
            return false;
        }
        Set <Integer> set=new HashSet<>();
        int i = 0;
        for (; i<=k&&i<nums.length ; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            else return true;
        }
        for (int j=0; j<nums.length&&i <nums.length;) {
            set.remove(nums[j]);
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
            else return true;
            i++;
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        _219存在重复元素2 a=new _219存在重复元素2();
        System.out.println(a.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }

}
