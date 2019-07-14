package se.other;

/***
 *@ClassName Object_
 *@Description
 * @author sukbear
 * @create 2019-03-05 10:26
 */

/**这些方法必须存在于同步中；
        使用这些方法必须标识同步所属的锁；
        锁可以是任意对象，所以任意对象调用方法一定定义在Object类中。
        Condition是在java 1.5中才出现的，它用来替代传统的Object的wait()、notify()实现线程间的协作，相比使用Object的wait()、notify()，
       使用Condition1的await()、signal()这种方式实现线程间协作更加安全和高效。
       因此通常来说比较推荐使用Condition，阻塞队列实际上是使用了Condition来模拟线程间协作。
        Condition是个接口，基本的方法就是await()和signal()方法；
        Condition依赖于Lock接口，生成一个Condition的基本代码是lock.newCondition()
        调用Condition的await()和signal()方法，都必须在lock保护之内，就是说必须在lock.lock()和lock.unlock之间才可以使用
        Conditon中的await()对应Object的wait()；
        Condition中的signal()对应Object的notify()；
        Condition中的signalAll()对应Object的notifyAll()；*/
public class Object_ {
    public static void main(String[] args) {
        Object obj = new Object();
        obj.toString();
        obj.hashCode();
        obj.equals("d");
        //wait notify
    }
}
