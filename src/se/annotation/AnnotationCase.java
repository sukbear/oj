package se.annotation;

/***
 *@ClassName AnnotationCase
 *@Description
 * @author sukbear
 * @create 2019-09-07 12:57
 */
@Description("I am a class Annotation")
public class AnnotationCase {
    @Description("I am a method Annotation")
    void hello() {
        System.out.println("hello");
    }


}
