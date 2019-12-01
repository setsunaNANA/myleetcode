import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class _215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1,o2)->(o1-o2));
        for (int n:nums
             ) {
            priorityQueue.add(n);
            if (priorityQueue.size()==k+1) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        _215数组中的第K个最大元素 a=new _215数组中的第K个最大元素();
        System.out.println(a.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
// 0 1 2 3 4 5
// 1 2 3 4 5 6
}
