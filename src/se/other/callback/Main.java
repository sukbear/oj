package se.other.callback;

/**
 * @author sukbear
 * @create 2018-12-24 10:00
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("fuck");
        client.doSomething();
    }
}
