package jianzhioffer.fifty;

import java.util.LinkedList;

/***
 *@ClassName CharStreamFirst
 *@Description
 * @author sukbear
 * @create 2019-09-05 22:40
 */
public class CharStreamFirst {
    //Insert one char from stringstream
    private int[] cnts = new int[256];
    private LinkedList<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
