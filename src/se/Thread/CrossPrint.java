package se.Thread;

/**
 * @author sukbear
 * @ClassName Main
 * @Description
 * @create 2019-09-25 20:56
 */
public class CrossPrint {
    private static Object object = new Object();

    public static void main(String[] args) {
        new Thread(new Num()).start();

        Thread a =  new Thread(new Char());
       a.start();
    }

    static class Char implements Runnable {
        private void printChar() {
            for (int i = 'a'; i <= 'z'; i++) {
                synchronized (object) {
                    System.out.print((char) i);
                    object.notifyAll();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void run() {
            printChar();
        }
    }

    static class Num implements Runnable {
        @Override
        public void run() {
            printNum();
        }

        private void printNum() {
            for (int i = 0; i <= 50; i+=2) {
                synchronized (object){
                    System.out.print(i+1);
                    System.out.print(i+2);
                    object.notifyAll();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}