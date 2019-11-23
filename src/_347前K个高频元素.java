import kotlin.jvm.functions.Function1;

import java.util.*;

public class _347前K个高频元素 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)-> map.get(n1) - map.get(n2));
        for (int cur : nums
        ) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        for (int cur:map.keySet()
             ) {

            heap.add(cur);
            if (heap.size()>k) {
                heap.poll();
            }
        }
        List<Integer> list=new ArrayList<>();
        for (int cur:heap
             ) {
            list.add(cur);
        }
        Collections.reverse(list);
        return list;
    }
}
