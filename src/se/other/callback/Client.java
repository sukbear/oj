package se.other.callback;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sukbear
 * @create 2018-12-24 9:39
 */
public class Client implements ProcessCallBack {
    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg(final String msg) {
        System.out.println("客户端发送的消息： " + msg);
        ExecutorService service = new ThreadPoolExecutor(2, 4, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.CallerRunsPolicy());
        service.submit(() -> server.getClientMsg(Client.this, msg));
        System.out.println("客户端发送成功");
        service.shutdown();
    }
    public void doSomething(){
        System.out.println("客户端处理其他事情");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("客户端其他处理完了");
    }
    @Override
    public void process(String status) {
        System.out.println("客户端：服务器回调状态为："+status);
    }
}
