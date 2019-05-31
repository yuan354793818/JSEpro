import io.netty.handler.codec.http.HttpMethod;
import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.RestExpress;

public class RestExpressDemo {
    public static void main(String[] args) {
        RestExpress server = new RestExpress().setName("demo");
        server.uri("/demo", new Object() {
            @SuppressWarnings("unused")
            public String read(Request req, Response res) {
                String value = req.getHeader("demo");
                res.setContentType("text/xml");

                if (value == null)
                {
                    return "<http_test><error>no value specified</error></http_test>";
                }
                else
                {
                    return String.format("<http_test><value>%s</value></http_test>", value);
                }
            }
        }).method(HttpMethod.GET);


        server.bind(8084);
        server.awaitShutdown();
    }

}
