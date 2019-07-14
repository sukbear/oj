package se.other.callback;

import java.util.concurrent.TimeUnit;

/**
 * @author sukbear
 * @create 2018-12-24 9:40
 */
public class Server {
    public void getClientMsg(ProcessCallBack callBack,String msg){
        System.out.println("服务端： 服务端收到的消息为: "+msg);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("服务端：数据处理成功,返回成功状态200");
        String status = "200";
        callBack.process(status);
    }

}
