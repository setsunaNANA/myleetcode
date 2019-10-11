/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。
	所有数字（包括 target）都是正整数。
	解集不能包含重复的组合。
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]*/

import java.util.ArrayList;
import java.util.List;

public class _39组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return  null;
        }
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> tlist=new ArrayList<Integer>();
        digui(list, tlist, candidates, target, 0);
        return list;
    }
    void digui(List<List<Integer>> list, List<Integer> tlist,int[] candidates, int target, int start){
        for (int i = start; i < candidates.length; i++) {
            if (target == 0) {
                List<Integer> newlist=new ArrayList<>(tlist);
                list.add(newlist);
                return;
            }
            else if (target<0) {
                return;
            }
            else {
                tlist.add(candidates[i]);
                digui(list, tlist, candidates, target-candidates[i],i);
                tlist.remove(tlist.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates={2,3,5};
        _39组合总和 a= new _39组合总和();
        a.combinationSum(candidates, 5);
    }
}
