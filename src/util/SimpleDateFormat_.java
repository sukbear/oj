package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *@ClassName SimpleDateFormat_
 *@Description
 * @author sukbear
 * @create 2019-05-27 20:32
 */
public class SimpleDateFormat_ {
    /**
     * SimpleDateFormat的线程安全性问题
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 使用共享变量，使用的时候进行同步
     **/
    public static Date parse1(String dateStr) {
        synchronized (sdf) {
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 使用ThreadLocal
     */
    private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();

    public static Date parse2(String dateStr) {
        SimpleDateFormat sdf = tl.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            tl.set(sdf);
        }
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
