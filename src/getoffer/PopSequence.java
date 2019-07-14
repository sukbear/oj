package getoffer;

import java.util.Stack;

/**
 * @author sukbear
 * @create 2019-03-01 11:00
 */
public class PopSequence {
    /**
     *
     * 将第一个元素放入栈中，判断栈顶元素与出栈顺序第一个元素是否相等
     * 若相等，出栈，popIndex后移
     * 若不等，压栈，pushIndex后移
     * 最后压栈顺序遍历完成，辅助栈不为空，return isEmpty();
     * */
    private static boolean fun(int[] pushOrder, int[] popOrder, int n) {
        if (pushOrder.length == 0 || popOrder.length == 0) {
            return false;
        }
        if (pushOrder.length != popOrder.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushOrder[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popOrder[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 5, 3, 2, 1};
        System.out.println(fun(pushOrder, popOrder, 5));
    }

}
