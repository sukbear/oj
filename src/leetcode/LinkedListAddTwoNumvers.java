package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/***
 *@ClassName LinkedListAddTwoNumvers
 *@Description
 * @author sukbear
 * @create 2019-04-17 14:52
 */
public class LinkedListAddTwoNumvers {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     */
    public static String convert(String s, int numRows) {


        if (numRows == 1) {
            return s;
        }
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }
        // 行号指示器
        int curRow = 0;
        // 向上还是向下
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        StringBuilder com = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            com.append(s.charAt(i));
        }
        return sb.toString().equals(com.toString());
    }


    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(reps[i]);
            }
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        if(s.length()==1){return map.get(s.charAt(0));}
        char[] chars = s.toCharArray();
        int res = 0;
        for(int i =0;i<chars.length-1;i++){
            int m = map.get(chars[i]);
            int n = map.get(chars[i+1]);
            if(m<n){
                res -=m;
            }else{
                res+=m;
            }
        }
        res += map.get(chars[chars.length-1]);
        return res;
    }

    public static void main(String[] args) {

        System.out.println(intToRoman(49));
        System.out.println();
    }
}
