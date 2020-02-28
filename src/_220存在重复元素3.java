import com.sun.source.tree.Tree;
import kotlin.reflect.jvm.internal.impl.name.NameUtils;

import java.util.TreeSet;

public class _220存在重复元素3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t<0){
            return false;
        }
        TreeSet<Long> treeSet=new TreeSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (i > k) {
                treeSet.remove((long)nums[i-k-1]);//Set大小为k
            }
            Long ceil=treeSet.ceiling((long)nums[i]-t);//取出Set中>=nums[i]-t的最小元素
            if (ceil != null&&ceil<=(long)nums[i]+t) {//若该元素<==nums[i]+t  说明nums[i]和它相差不超过t
                return true;
            }
            treeSet.add((long)nums[i]);//先判断集合里的元素  再添加当前元素
        }
        return false;
    }
    /*public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t<0){
            return false;
        }
        TreeSet<Long> treeSet=new TreeSet<>();
        if (k >nums.length-1) {
            k=nums.length-1;
        }
        for (int i = 0; i <=k ; i++) {
            treeSet.add((long)nums[i]);
        }
        for (int i = 0; i <=k ; i++) {
            if (treeSet.size()<=k) {
                return true;
            }
            Long higher=treeSet.higher((long)nums[i]);
            Long lower=treeSet.lower((long)nums[i]);

            if (lower != null&&Math.abs(lower-nums[i])<=t||higher != null&&Math.abs(higher-nums[i])<=t) {
                return true;
            }
        }
        for (int i = k+1; i <nums.length ; i++) {

            if (treeSet.size()<=k) {
                return true;
            }// 0 1 2 3 4
            treeSet.remove((long)nums[i-k-1]);
            treeSet.add((long)nums[i]);
            Long higher=treeSet.higher((long)nums[i]);
            Long lower=treeSet.lower((long)nums[i]);

            if (lower != null&&Math.abs(lower-nums[i])<=t||higher != null&&Math.abs(higher-nums[i])<=t) {
                return true;
            }
        }
        return false;
    }*/
}

