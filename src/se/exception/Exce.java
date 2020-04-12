package se.exception;

/***
 *@ClassName Exce
 *@Description
 * @author sukbear
 * @create 2019-09-21 13:33
 */
public class Exce {
    /***所有的异常都是从Throwable(类不是抽象类)继承而来的，是所有异常的共同祖先
     * error (stackOverflow,OOM) 错误无法恢复或不可能捕获
     *
     * .Exception，是另外一个非常重要的异常子类。它规定的异常是程序本身可以处理的异常。
     * 异常和错误的区别是，异常是可以被处理的，而错误是没法处理的。
     * 可检查的异常需要再代码里处理 Io是检查异常、RuntimeException是非检查异常（无法预先捕捉处理）
     * exception(IOException(EOFException,FileNotFound)，SQLException)
     *
     * RuntimeException{
     * IllegalArgumentException
     * NullPointer
     * ArrayIndexOutOfBound
     * unkownTypeException
     * ClassCastException
     *
     * 这些异常一般是由程序逻辑错误引起的.
     * 出现运行时异常后，如果没有捕获处理这个异常（即没有catch），
     * 系统会把异常一直往上层抛，一直到最上层，如果是多线程就由Thread.run()抛出，
     * 如果是单线程就被main()抛出。
     *
     * 如果不对运行时异常进行处理，那么出现运行时异常之后，要么是线程中止，要么是主程序终止。
     * }
     * )
     * throws 关键字放在方法签名的尾部
     * throw 关键字方法里抛出异常
     * 捕捉到异常可以记录日志,方便调试,,,,然后再把异常throw出去.让上层框架进行处理...
     *
     * finally 关键字用来创建在 try 代码块后面执行的代码块。
     * （除非本身语句块发生异常、或者虚拟机死亡、cpu死亡这些情况）
     * 一定能执行
     *
     * 检查式异常：我们经常遇到的IO异常及sql异常就属于检查式异常。
     * 对于这种异常，java编译器要求我们必须对出现的这些异常进行catch
     * 所以 面对这种异常不管我们是否愿意，只能自己去写一堆catch来捕捉这些异常。

     运行时异常：我们可以不处理。当出现这样的异常时，总是由虚拟机接管。
     比如：我们从来没有人去处理过NullPointerException异常，它就是运行时异常，
     并且这种异常还是最常见的异常之一。
     * */
    public static void main(String[] args)  {
        System.out.println(5/0);
    }
}
