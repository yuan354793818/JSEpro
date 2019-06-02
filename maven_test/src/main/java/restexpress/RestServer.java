package restexpress;

import io.netty.handler.codec.http.HttpMethod;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.RestExpress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RestServer {
    public static void main(String[] args) {
        RestExpress server = new RestExpress();
        server.uri("/doprint", new Object() {

            public String read(Request request,Response response) throws FileNotFoundException {
                HttpClient client=new HttpClient();
                //RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000000).build();
                PostMethod post = new PostMethod("http://localhost:8085/print");
                File file = new File("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\restexpress\\ppddff.pdf");
                post.setRequestEntity(new FileRequestEntity(file,"application/pdf"));
                //post.setConfig(requestConfig);
                //MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
                //File file = new File("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\restexpress\\ppddff.pdf");
                //multipartEntityBuilder.addBinaryBody("file",file);
                //HttpEntity entity = multipartEntityBuilder.build();
                //post.setEntity(entity);
                client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
                try {
                    client.executeMethod(post);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "success";
            }
        }).method(HttpMethod.GET);
        server.bind(8084);
        server.awaitShutdown();
    }
}
