package se.annotation;

import java.lang.reflect.Method;

/***
 *@ClassName ParseAnnotation
 *@Description
 * @author sukbear
 * @create 2019-09-07 13:10
 */
public class ParseAnnotation {
    public static void main(String[] args) {
        Class c = AnnotationCase.class;
        boolean exit = c.isAnnotationPresent(Description.class);
        if (exit) {
            Description d = (Description) c.getAnnotation(Description.class);
            System.out.println(d.value());
        }
        Method[] ms = c.getMethods();
        for (Method m : ms) {
            if (m.isAnnotationPresent(Description.class)) {
                Description des = m.getAnnotation(Description.class);
                System.out.println(des.value());
            }
        }
    }
}
