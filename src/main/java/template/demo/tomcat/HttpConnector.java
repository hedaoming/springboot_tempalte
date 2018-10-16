package template.demo.tomcat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by peishen on 2018/10/11
 **/
public class HttpConnector implements Runnable{

    private static final boolean SHUTDOWN = false;
    private int port = 8080;

    public HttpConnector(int port){
        this.port = port;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port, 10, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!SHUTDOWN){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                continue;
            }

            HttpProcesstor httpProcesstor = new HttpProcesstor();
            try {
                httpProcesstor.process(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void startServer(){
        Thread thread = new Thread(this);
        thread.start();
    }
}
