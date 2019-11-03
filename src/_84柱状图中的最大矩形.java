import javax.crypto.spec.PSource;
import java.util.Stack;

public class _84柱状图中的最大矩形 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int minheight = Integer.MAX_VALUE;
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            minheight = Math.min(minheight, heights[i]);
            while (!stack.isEmpty()) {
                if (stack.peek() == -1 || heights[i] >= heights[stack.peek()]) {
                    stack.push(i);
                    break;
                } else {
                    int index = stack.pop();
                    max = Math.max(max, heights[index] * (i - stack.peek()-1));
                }
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()&&stack.peek()!=-1) {
                int index = stack.pop();
                max = Math.max(max, heights[index] * (heights.length - stack.peek()-1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _84柱状图中的最大矩形 a=new _84柱状图中的最大矩形();
        System.out.println(a.largestRectangleArea(new int[]{2,1,2}));
    }


}
