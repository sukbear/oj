package se.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/***
 *@ClassName Compare
 *@Description
 * @author sukbear
 * @create 2019-09-12 21:50
 */
public class Compare {
    /**小于是负数，大于是正数，等于是零*/
    Student s = new Student();
    public static void main(String[] args) {
        ArrayList<Compare.Student> list = new ArrayList();
        Compare obj = new Compare();
        list.add(new Compare.Student("ss",18,20f));
        list.add(new Compare.Student("ss",19,30f));
        list.add(new Compare.Student("ss",15,40f));
        list.add(new Compare.Student("ss",11,40f));
        list.add(new Compare.Student("ss",19,50f));
        Collections.sort(list);
        for(Compare.Student ss:list){
            System.out.println(ss);
        }
    }
 static   class Student implements Comparable<Student>{
        String name;
        Integer age;
        Float score;

     public Student() {
     }

     public Student(String name, Integer age, Float score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public int compareTo(Student s) {
           if(this.score>s.score){
               return -1;
           }else if(this.score<s.score){
               return 1;
           }else{
               if(this.age>s.age){
                   return 1;
               }else if(this.age<s.age){
                   return -1;
               }else{
                   return 0;
               }
           }
        }

     @Override
     public String toString() {
         return "Student{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 ", score=" + score +
                 '}';
     }
 }
}
class StringCompare implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}