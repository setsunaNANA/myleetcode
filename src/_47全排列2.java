import java.util.*;

public class _47全排列2 {
    List<List<Integer>> res=new ArrayList<>();
    Stack<Integer> stack=new Stack<>();
    boolean [] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visit=new boolean[nums.length];
        help(nums, 0);
        return res;
    }
    void help(int []nums,int n){
        if (n == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (visit[i]) {
                continue;
            }
            if (i-1>=0&&nums[i]==nums[i-1]&&!visit[i-1]) {
                continue;
            }
            stack.push(nums[i]);
            visit[i]=true;
            help(nums, n+1);
            visit[i]=false;
            stack.pop();
        }
    }

    public static void main(String[] args) {
        _47全排列2 a= new _47全排列2();
        System.out.println(a.permuteUnique(new int[]{1,1,2}));

    }
}
