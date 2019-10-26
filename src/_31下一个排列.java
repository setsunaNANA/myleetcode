public class _31下一个排列 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        for (; i >0 ; i--) {
            if(nums[i]>nums[i+1]){
                break;
            }
        }
        if (i == 0) {
            int m=0;
            int n=nums.length-1;
            while (m<n){
                int T=nums[m];
                nums[m]=nums[n];
                nums[n]=T;
                m++;
                n--;
            }
            return;
        }
        int j=nums.length-1;
        for (; j >i ; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;

        int m=i+1;
        int n=nums.length-1;
        while (m<n){
            int T=nums[m];
            nums[m]=nums[n];
            nums[n]=T;
            m++;
            n--;
        }
    }
}
