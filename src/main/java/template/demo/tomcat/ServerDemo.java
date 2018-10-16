package template.demo.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by peishen on 2018/10/10
 **/
public class ServerDemo {

    private static final boolean SHUTDOWN = false;
    public void createServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088,2, InetAddress.getByName("127.0.0.1"));
        while (!SHUTDOWN){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            
        }

    }
}
