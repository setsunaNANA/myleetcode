public class _41缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        if (len == 0) {
            return 1;
        }
        for (int i = 0; i <len ; i++) {
            while (pos_aviliable(i, nums)) {
                exchange(i,nums[i]-1,nums);
                for (int j = 0; j <len ; j++) {
                    System.out.print(nums[j]);
                }
                System.out.println();
            }
        }
        for (int i = 0; i <len ; i++) {
            int cur=nums[i];
            if (cur!=i+1) {
                return i+1;
            }
        }
        return len+1;
    }
    boolean pos_aviliable(int index,int[] nums){
        int cur=nums[index];//cur-1为当前元素需要放置到的位置
        if (cur-1<0||cur-1>nums.length-1||nums[cur-1]==cur) {
            return false;
        }
        else return true;
    }

    void exchange(int index1,int index2,int nums[]){
        int t=nums[index2];
        nums[index2]=nums[index1];
        nums[index1]=t;
    }
}
