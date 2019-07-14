package se.concurrent.SemaphoreAndExchanger.Semaphore.Producer_Customer;

/**
 * @author sukbear
 * @create 2018-12-12 15:28
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadA[] arrayA = new ThreadA[60];
        ThreadB[] arrayB = new ThreadB[60];
        for(int i = 0;i<60;i++){
            arrayA[i] = new ThreadA(service);
            arrayB[i] = new ThreadB(service);
        }
        Thread.sleep(2000);
        for(int i = 0; i < 60;i++){
            arrayA[i].start();
            arrayB[i].start();
        }
    }
}
