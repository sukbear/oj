package algorithm.recursive;

/***
 *@ClassName PrintAllSubsquence
 *@Description
 * @author sukbear
 * @create 2019-05-08 22:49
 */
public class PrintAllSubsquence {
    /**
     * 字符串的子序列
     * * */
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    private static void process(char[] chs, int i)
    {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = tmp;
    }


    public static void main(String[] args) {
        printAllSubsquence("abc");
    }
}
