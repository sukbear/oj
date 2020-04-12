package se.jmm;

/***
 *@ClassName String_Integer
 *@Description
 * @author sukbear
 * @create 2019-09-18 20:39
 */
public class String_Integer {

    public static void main(String[] args) {
/*        //String
        String str1 = "abcd";//先检查字符串常量池中有没有"abcd"，如果字符串常量池中没有，则创建一个，然后 str1 指向字符串常量池中的对象，如果有，则直接将 str1 指向"abcd""；
        String str2 = new String("abcd");//堆中创建一个新的对象
        String str3 = new String("abcd");//堆中创建一个新的对象
        System.out.println(str1==str2);//false
        System.out.println(str2==str3);//false*/
       // 第一种方式是在常量池中拿对象；
       // 第二种方式是直接在堆内存空间创建一个新的对象。
        //直接使用双引号声明出来的 String 对象会直接存储在常量池中。
/*        如果不是用双引号声明的 String 对象，可以使用 String 提供的 intern 方法。
        String.intern() 是一个 Native 方法，它的作用是：
        如果运行时常量池中已经包含一个等于此 String 对象内容的字符串，
        则返回常量池中该字符串的引用；
        如果没有，JDK1.7之前（不包含1.7）的处理方式是在常量池中创建与此 String 内容相同的字符串，
        并返回常量池中创建的字符串的引用，JDK1.7以及之后的处理方式是在常量池中记录此字符串的引用，
        并返回该引用。*/

        String str1 = "str";
        String str2 = "ing";

        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false
        String s1 = new String("abc");//这句话创建了几个字符串对象？
        //将创建 1 或 2 个字符串。如果池中已存在字符串常量“abc”，则只会在堆空间创建一个字符串常量“abc”。如果池中没有字符串常量“abc”，那么它将首先在池中创建，然后在堆空间中创建，因此将创建总共 2 个字符串对象。

      //  Java 基本类型的包装类的大部分都实现了常量池技术，
        // 即 Byte,Short,Integer,Long,Character,Boolean；
        // 这 5 种包装类默认创建了数值[-128，127] 的相应类型的缓存数据
        // ，但是超出此范围仍然会去创建新的对象。
        // 为啥把缓存设置为[-128，127]区间？（参见issue/461）性能和资源之间的权衡。


       // 语句 i4 == i5 + i6，因为+这个操作符不适用于 Integer 对象，
        // 首先 i5 和 i6 进行自动拆箱操作，进行数值相加，即 i4 == 40。
        // 然后 Integer 对象无法与数值进行直接比较，
        // 所以 i4 自动拆箱转为 int 值 40，最终这条语句转为 40 == 40 进行数值比较。
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2   " + (i1 == i2));
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));
        System.out.println("i1=i4   " + (i1 == i4));
        System.out.println("i4=i5   " + (i4 == i5));
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));
        System.out.println("40=i5+i6   " + (40 == i5 + i6));
    }
}
