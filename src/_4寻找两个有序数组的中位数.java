/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。
示例 1:
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0
0  1 2 3
|1
2 2| 3 4
 */
//asdsadadds
public class _4寻找两个有序数组的中位数 {
    /**public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)return findMedianSortedArrays(nums2, nums1);
        if (nums1.length==0){
            if (nums2.length%2==0) {
                return ((double)nums2[nums2.length/2-1]+(double)nums2[nums2.length/2])/2 ;
            }
            else {
                return nums2[nums2.length/2];
            }
        }
        int totallen = nums1.length+nums2.length;
        int n1cut=0;
        int n2cut=totallen/2-n1cut;
        int n1l=Integer.MIN_VALUE;
        int n1r=nums1[n1cut];
        int n2l=nums2[n2cut-1];
        int n2r;
        if (n2cut == nums2.length)
            n2r= Integer.MAX_VALUE;
        else  n2r=nums2[n2cut];
        while(!(n1l<=n2r&&n2l<=n1r)){
            System.out.println(n1cut);

            if (n2l > n1r) {
                n1cut++;
                n2cut--;
            //n2cut=totallen/2-n1cut;
               n1cut=
               n1l=nums1[n1cut-1];
             if (n1cut == nums1.length)
                 n1r= Integer.MAX_VALUE;
             else n1r=nums1[n1cut];
                if (n2cut == 0)
                    n2l= Integer.MIN_VALUE;
                else   n2l=nums2[n2cut-1];
             n2r=nums2[n2cut];
            }
        }
        if (totallen % 2==0) {
            double s1=Math.max(n1l, n2l);
            double s2=Math.min(n1r, n2r);
            double x=(s1+s2)/2;
            return x;
        }
        else {
            return Math.min(n1r, n2r);
        }
    }*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)return findMedianSortedArrays(nums2, nums1);
        if (nums1.length==0){
            if (nums2.length%2==0) {
                return ((double)nums2[nums2.length/2-1]+(double)nums2[nums2.length/2])/2 ;
            }
            else {
                return nums2[nums2.length/2];
            }
        }
        int totallen = nums1.length+nums2.length;
        int lindex=0;
        int rindex=nums1.length;
        int n1cut=(lindex+rindex)/2;
        int n2cut=totallen/2-n1cut;
        int n1l,n1r,n2l,n2r;

        n1l=n1cut==0?Integer.MIN_VALUE:nums1[n1cut-1];
        n1r=n1cut==nums1.length?Integer.MAX_VALUE:nums1[n1cut];
        n2l=n2cut==0?Integer.MIN_VALUE:nums2[n2cut-1];
        n2r=n2cut==nums2.length?Integer.MAX_VALUE:nums2[n2cut];
        while(!(n1l<=n2r&&n2l<=n1r)){
            System.out.println(n1cut);

            if (n2l > n1r) {

                lindex=n1cut+1;
            }
            else if (n1l>n2r){
                rindex = n1cut-1;
            }
            n1cut=(lindex+rindex)/2;
            n2cut=totallen/2-n1cut;
            n1l=n1cut==0?Integer.MIN_VALUE:nums1[n1cut-1];
            n1r=n1cut==nums1.length?Integer.MAX_VALUE:nums1[n1cut];
            n2l=n2cut==0?Integer.MIN_VALUE:nums2[n2cut-1];
            n2r=n2cut==nums2.length?Integer.MAX_VALUE:nums2[n2cut];
        }
        if (totallen % 2==0) {
            double s1=Math.max(n1l, n2l);
            double s2=Math.min(n1r, n2r);
            double x=(s1+s2)/2;
            return x;
        }
        else {
            return Math.min(n1r, n2r);
        }
    }

    public static void main(String[] args) {
        _4寻找两个有序数组的中位数 a= new _4寻找两个有序数组的中位数();
        int[] nums1={1};
        int[] nums2={2,3,4};
        System.out.println(a.findMedianSortedArrays(nums1, nums2));
    }


}
