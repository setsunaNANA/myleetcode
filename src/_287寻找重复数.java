public class _287寻找重复数 {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        slow=nums[0];
        fast=nums[nums[0]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
