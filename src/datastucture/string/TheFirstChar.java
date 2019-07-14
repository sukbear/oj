package datastucture.string;

import java.util.BitSet;
import java.util.LinkedList;

/***
 *@ClassName TheFirstChar
 *@Description
 * @author sukbear
 * @create 2019-05-23 18:31
 */
public class TheFirstChar {
    /**1、
     * 找到第一个只出现一次的字符
     * 利用两个bitset 00->01
     * 01->11
     * 最后找到那个i
     * */
    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                // 0 0 -> 0 1
                bs1.set(c);
            } else if (bs1.get(c) && !bs2.get(c)) {
                // 0 1 -> 1 1
                bs2.get(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 0 1
            if (bs1.get(c) && !bs2.get(c)) {
                return i;
            }
        }
        return -1;
    }
/**
 * 2、利用hashmap 存储 char,int 找到第一个1
 * */

    /**
     *  字符流中第一个不重复的字符
     *  请实现一个函数用来找出字符流中第一个只出现一次的字符。
     *  例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
     *  当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
     *  */
    static class Inner{
        private int[] cnts = new int[256];
        private LinkedList<Character> queue = new LinkedList<>();
        public void insert(char ch){
            cnts[ch]++;
            queue.add(ch);
            while(!queue.isEmpty()&&cnts[queue.peek()]>1){
                queue.poll();
            }
        }
        public char findFirstAppear(){
            return queue.isEmpty()? '#':queue.peek();
        }


    }
}
