import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List <List<Integer>> res = new ArrayList<>();
        List<Integer> tlist=new ArrayList<>();
        Arrays.sort(nums);
        int i,j,k,l;

        for ( i = 0; i <nums.length-3 ; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (j = i+1; j <nums.length-2 ; j++) {
                if (j!=i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                for (k = j+1,l=nums.length-1; k <l ; ) {
                    int sum=target-nums[i]-nums[j];
                    if(k!=j+1&&nums[k]==nums[k-1]){
                        k++;
                        continue;
                    }
                    /*while (l!=nums.length-1&&nums[l]==nums[l-1]&&k<l){
                        l--;
                        continue;
                    }*/
                    if (nums[k]+nums[l]<sum) k++;
                    else if (nums[k]+nums[l]>sum) l--;
                    else {
                        tlist.add(nums[i]);
                        tlist.add(nums[j]);
                        tlist.add(nums[k]);
                        tlist.add(nums[l]);
                        res.add(new ArrayList<>(tlist));
                        tlist.clear();
                        k++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _18四数之和 a=new _18四数之和();
        a.fourSum(new int[]{-1,2,2,-5,0,-1,4}, 3);
    }


}
