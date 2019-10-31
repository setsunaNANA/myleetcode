public class _75颜色分类 {
    public void sortColors(int[] nums) {
        if (nums == null||nums.length==0) {
            return;
        }
        int index0=0;
        int index2=nums.length-1;
        int indexcur=0;
        for (; indexcur <=index2 ; ) {
            if (nums[indexcur]==0) {
                int t=nums[indexcur];
                nums[indexcur]=nums[index0];
                nums[index0]=t;
                index0++;indexcur=index0;
            }
            else if (nums[indexcur]==2) {
                int t=nums[indexcur];
                nums[indexcur]=nums[index2];
                nums[index2]=t;
                index2--;
            }
            else indexcur++;
        }

    }
}
