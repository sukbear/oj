package se.concurrent.Phaser;

/**
 * @author sukbear
 * @create 2018-12-12 18:04
 */
public class Main {
    public static void main(String[] args) {
        TestPhaser phaser = new TestPhaser();
        StudentTask[] studentTask = new StudentTask[5];
        for(int i =0;i < studentTask.length;i++){
            studentTask[i] = new StudentTask(phaser);
            phaser.register();
        }
        Thread[] threads = new Thread[studentTask.length];
        for(int i = 0;i < threads.length;i++){
            threads[i] = new Thread(studentTask[i],"Student"+i);
            threads[i].start();
        }

        for(int i =0; i< studentTask.length;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("finished");
    }
}
