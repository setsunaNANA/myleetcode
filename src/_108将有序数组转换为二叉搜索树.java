public class _108将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return creat(0,nums.length-1,nums);
    }
    private TreeNode creat(int start,int end,int []nums){
        if (start>end) {
            return null;
        }
        int mid=(start+end)/2;
        TreeNode cur=new TreeNode(nums[mid]);
        cur.left=creat(start, mid-1, nums);
        cur.right=creat(mid+1, end, nums);
        return cur;
    }
}
