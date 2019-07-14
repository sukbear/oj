package getoffer;

/***
 *@ClassName ValidBrackets
 *@Description
 * @author sukbear
 * @create 2019-03-06 9:45
 */

import java.util.Stack;

/**
 * 思路：遇到左括号，直接压栈。
 * 遇到右括号：
 * 1、栈为空，return false;
 * 2、栈不为空，栈顶是否是对应左括号；若是 则继续，否则return false;
 */
public class ValidBrackets {
    private static boolean isSym(char char1, char char2) {
        return (char1 == '(' && char2 == ')') || (char1 == '[' && char2 == ']') || (char1 == '{' && char2 == '}');
    }

    private static boolean right(String str) {
        Stack<Character> s = new Stack<>();
        char[] chars = str.toCharArray();
        for (char i : chars) {
            if (s.size() == 0) {
                s.push(i);
            } else if (isSym(s.peek(), i)) {
                s.pop();
            } else {
                s.push(i);
            }
        }
        return s.size() == 0;
    }
}
