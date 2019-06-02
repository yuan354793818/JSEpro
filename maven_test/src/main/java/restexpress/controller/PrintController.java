package restexpress.controller;

import io.netty.buffer.ByteBuf;
import noclassify.PrintResult;
import noclassify.PrintResultState;
import org.restexpress.Request;
import org.restexpress.Response;

public class PrintController {
    public PrintResult create(Request request, Response response) {
        System.out.println("sdsdsds");
        ByteBuf body = request.getBody();
        return new PrintResult(PrintResultState.NO_STATE);
    }
}
