public class _88合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int cur=m+n-1;
        while (p1>=0&&p2>=0){
            if (nums1[p1]<=nums2[p2]) {
                nums1[cur]=nums2[p2];
                p2--;
            }
            else {
                nums1[cur]=nums1[p1];
                p1--;
            }
            cur--;
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }

    public static void main(String[] args) {
        _88合并两个有序数组 a =new _88合并两个有序数组();
        a.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
