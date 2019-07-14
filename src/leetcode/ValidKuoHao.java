package code.leetcode;

import java.util.Stack;

/***
 *@ClassName ValidKuoHao
 *@Description
 * @author sukbear
 * @create 2019-04-18 12:15
 */
public class ValidKuoHao {
    boolean pair(Character c1, Character c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        } else if (c1 == '[' && c2 == ']') {
            return true;
        } else {
            return true;
        }
    }

    boolean idValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (pair(stack.peek(),s.charAt(i))){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
