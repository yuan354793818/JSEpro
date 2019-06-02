package restexpress;

import io.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;
import restexpress.controller.PrintController;

public class RestClient {
    public static void main(String[] args) {
        RestExpress client = new RestExpress();
        client.uri("/print",new PrintController()).method(HttpMethod.POST);
        client.bind(8085);
        client.awaitShutdown();
    }
}
