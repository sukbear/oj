package leetcode;

import java.util.Stack;

/***
 *@ClassName RemoveKbitNumber
 *@Description
 * @author sukbear
 * @create 2019-04-12 17:49
 */
public class RemoveKbitNumber {

    /**
     * Given a non-negative integer num represented as a string, r
     * emove k digits from the number so that the new number is the smallest possible.
     * <p>
     * Note:
     * <p>
     * The length of num is less than 10002 and will be ≥ k.
     * The given num does not contain any leading zero.
     * <p>
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3,
     * and 2 to form the new number 1219 which is the smallest.
     */
    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            // 如果栈不空，且高位stack.peek()大于低位n，且可删除=>删除
            while (!stack.isEmpty() && n < stack.peek() && k != 0) {
                stack.pop();
                k--;
            }
            // 如果n!=0，入栈;如果n==0，但是栈不空，入栈
            if (n != 0 || !stack.isEmpty()) {
                stack.push(n);
            }
        }
        // 遍历完，但是还没去掉k个数字
        while (!stack.isEmpty() && k != 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            stack.push(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
