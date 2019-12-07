public class _80删除排序数组中的重复项2 {
    public int removeDuplicates(int[] nums) {
        int count=0;
        for (int i = 0; i <nums.length ; ) {
            int k=0;
            while (i>0&&i <nums.length&&nums[i]==nums[i-1]) {
                k++;
                if (k >= 2) {
                    count++;
                }
                nums[i-count]=nums[i];
                i++;
            }
            if (i <nums.length) {
                nums[i-count]=nums[i];
            }
            i++;
        }
        return nums.length-count;
    }

    public static void main(String[] args) {
        _80删除排序数组中的重复项2 a=new _80删除排序数组中的重复项2();
        System.out.println(a.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
