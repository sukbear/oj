package datastucture.stack;

import java.util.Stack;

/***
 *@ClassName LargestRectangleArea
 *@Description
 * @author sukbear
 * @create 2019-04-23 17:09
 */
public class LargestRectangleArea {
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     */
    /**
     * 利用单调栈  求解，总体思路是 以柱子i高度为矩形高度时所能形成最大面积（利用性质找出第i个柱子向左边和右边遍历时第一个比它低的柱子）
     * 单调栈定义：只存高度递增的柱子
     * 性质
     * 出栈时：
     * 那么如果单调栈为空了：说明没有比这个柱子更低的了（矩形宽度为这根柱子的序号：左边沿为0）
     * 如果单调栈不为空：说明栈里面的柱子高度都小，那么左边沿为栈顶柱子的序号
     * <p>
     * 矩形右边沿为i 因为你出栈 就说明你比别人低了，这已经是你能达到的面积极限了.出栈记录面积
     **/
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] heightn = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightn[i] = heights[i];
        }
        heightn[heights.length] = 0;
        //防止所有元素递增时加一个0最小，能弹出所有元素
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heightn.length; i++) {
            while (!s.isEmpty() && heightn[i] < heightn[s.peek()]) {
                int top = s.pop();
                maxArea = Math.max(maxArea, heightn[top] * (s.isEmpty() ? i : (i - s.peek() - 1)));
            }
            s.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        System.out.println(largestRectangleArea(a));
    }
}
