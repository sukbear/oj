package leetcode;

/***
 *@ClassName ValidBrackets
 *@Description
 * @author sukbear
 * @create 2019-04-18 18:37
 */


import java.util.Stack;

public class ValidBrackets {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 输入: "()[]{}"
     * 输出: true
     *
     * 输入: "(]"
     * 输出: false
     */
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if(stack.isEmpty()||stack.pop()!=ch){
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**扩展
     * 01问题只含01的字符串遇到01或10，消去，返回最后字符串的长度或字符串
     * 1100 0 ""
     * 11101 3 "111"
     * */
    static int strLen(String s){
        if(s.isEmpty()){return 0;}
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty()&&stack.peek()-ch!=0){
               stack.pop();
            }
            else{
               stack.push(ch);
            }
        }
        return stack.size();
    }
    public static void main(String[] args) {
        System.out.println(strLen("11101"));
    }
}
