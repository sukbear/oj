package se.math;

/***
 *@ClassName RedixChange
 *@Description
 * @author sukbear
 * @create 2019-06-02 9:38
 */
public class RedixChange {
    /**
     *
     * 进制转换 先转为10进制再转为其他进制（二进制到36进制）
     * 对应方法
     *
     * Integer.toString(10,radix);
     * Integer.parseInt(String s,radix);
     * */
    final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static String toString(int i, int radix) {
        if (radix == 10) {
            return String.valueOf(i);
        }
        char[] buf = new char[33];
        boolean negative = (i < 0);
        int charPos = 32;
        if (negative) {
            i = -i;
        }

        while (i >= radix) {
            buf[charPos--] = digits[(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[i];
        if (negative) {
            buf[--charPos] = '-';
        }
        return new String(buf, charPos, (33 - charPos));
    }

    public static String toInt(String s, int radix) {
        boolean negative = false;
        if (s.charAt(0) == '-') {
            s = s.substring(1);
            negative = true;
        }
        char[] buf = s.toCharArray();
        int len = buf.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += f(buf[i]) * (int) Math.pow(radix, len - i - 1);
        }
        if (negative) {
            res = -res;
        }
        return String.valueOf(res);
    }
    /**ASCII码和字符转换
     * 取（byte）
     * */
    static int f(char ch) {
        if (ch <= '9') {
            return (byte) (ch - 48);
        } else {
            return (byte) (ch - 87);
        }
    }

    public static void main(String[] args) {
        System.out.println(toInt("1100", 2));
    }
}
