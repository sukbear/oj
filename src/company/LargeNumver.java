package company;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/***
 *@ClassName LargeNumver
 *@Description
 * @author sukbear
 * @create 2019-05-22 20:35
 */
public class LargeNumver {
    /** BitSet
     * 常见的应用场景是对海量数据进行一些统计工作，比如日志分析、用户数统计等。
     * 有1千万个随机数，随机数的范围在1到1亿之间。
     * 现在要求写出一种算法，将1到1亿之间没有在随机数中的数求出来？
     */
    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            int randomResult = random.nextInt(100000000);
            list.add(randomResult);
        }
        System.out.println("产生的随机数有");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        BitSet bitSet = new BitSet(100000000);
        for (int i = 0; i < 10000000; i++) {
            bitSet.set(list.get(i));
        }

        System.out.println("0~1亿不在上述随机数中有" + bitSet.size());
        for (int i = 0; i < 100000000; i++) {
            if (!bitSet.get(i)) {
                System.out.println(i);
            }
        }
    }
}
