package template.demo.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by peishen on 2018/10/11
 **/
public class HttpProcesstor {

    /**
     * 处理请求
     * @param socket
     * @throws IOException
     */
    public void process(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        HttpRequest request = new HttpRequest(inputStream);
        request.parse();

        // 解析uri，确定请求类型是静态资源还是需要服务器处理的资源
        /*String uri = request.getUri();
        if (uri.startsWith("/static")){
            ServletProcessor servletProcessor = new ServletProcessor();
            servletProcessor.process(request);
        }else {
            StaticResourceProcessor staticResourceProcessor = new StaticResourceProcessor();
            staticResourceProcessor.process(request);
        }*/

        // httpResponse的内容
        String str = "hello!";
//        outputStream.write(str.getBytes());
        PrintWriter writer = new PrintWriter(outputStream);
        writer.write(str);
        writer.flush();
        if (outputStream != null){
            outputStream.close();
        }
        if (inputStream != null){
            inputStream.close();
        }
        socket.close();

    }
}
