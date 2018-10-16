package template.demo.tomcat;

/**
 * Created by peishen on 2018/10/11
 **/
public class BootStrap {

    public static void main(String[] args){
        int port = 8088;
        HttpConnector connector = new HttpConnector(port);
        connector.startServer();
        System.out.println("服务器启动成功!");
    }
}
