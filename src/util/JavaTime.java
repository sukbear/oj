package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/***
 *@ClassName JavaTime
 *@Description
 * @author sukbear
 * @create 2019-05-27 20:52
 */
public class JavaTime {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        //在Java 8中获取今天的日期
        System.out.println(today);
        //在Java 8中获取年月日
        System.out.println(today.getYear());
        System.out.println(today.getMonth());
        System.out.println(today.getDayOfWeek());
        //在Java 8中处理特定日期
        LocalDate dateOfBirth =  LocalDate.of(2010,10,14);
        LocalDate date1 =  LocalDate.of(2010,10,14);
        System.out.println(dateOfBirth);
        //判断两个日期相等equals被重载了
        System.out.println(date1.equals(dateOfBirth));
      //在Java 8中获取当前时间默认的格式是hh:mm:ss:nnn
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2);
        System.out.println(newTime);
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(now);
    }
}
