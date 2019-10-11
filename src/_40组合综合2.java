/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
	所有数字（包括目标数）都是正整数。
	解集不能包含重复的组合。
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */
import java.nio.file.Paths;
import java.util.*;

public class _40组合综合2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return  null;
        }//
        Arrays.sort(candidates);
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> tlist=new ArrayList<Integer>();
        Set<List<Integer>> hs = new HashSet<>();
        Set<Integer> ths=new HashSet<>();
        digui(list, tlist, hs,candidates,  target, 0);
        return list;
    }
    void digui(List<List<Integer>> list, List<Integer> tlist, Set<List<Integer>> hs,int[] candidates, int target, int start){
        for (int i = start; i <= candidates.length; i++) {
            if (target == 0) {
                List<Integer> newlist=new ArrayList<>(tlist);
                if (!hs.contains(newlist)) {
                   hs.add(newlist);
                list.add(newlist);
                }
                return;
            }
            else if (target<0) {
                return;
            }
            else {
                if (i==candidates.length) {
                    return;
                }
                tlist.add(candidates[i]);
                digui(list, tlist,hs, candidates, target-candidates[i],i+1);
                tlist.remove(tlist.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] candidates={2,5,1,1,2,3,3,3,1,2,2};
        _40组合综合2 a= new _40组合综合2();
        a.combinationSum2(candidates, 5);
    }

}
