package template.demo.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

/**
 * Created by peishen on 2018/10/11
 **/
public class HttpRequest {

    InputStream inputStream;
    StringBuffer stringBuffer;
    Hashtable headers =  new Hashtable();


    public HttpRequest(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public void setHeaders(){
        if (stringBuffer != null){
            // 解析stringBuffer然后封装进hashtable
        }

    }

    public void parse() throws IOException {
        byte[] buffer = new byte[2048];
        stringBuffer = new StringBuffer();
        while (inputStream.read(buffer) != -1){
            int i = 0;
            while (buffer.length > i){
                char c = (char) buffer[i];
                stringBuffer.append(c);
                i++;
            }
        }
        System.out.println(stringBuffer);
    }

    public String getUri(){
        if (stringBuffer != null){
            return stringBuffer.substring(stringBuffer.indexOf("/"), stringBuffer.indexOf(" HTTP"));
        }else {
            throw new IllegalArgumentException("HttpRequest未初始化");
        }
    }
}
