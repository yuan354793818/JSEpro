package restexpress.controller;

import org.restexpress.Request;
import org.restexpress.Response;
import restexpress.bean.ServerInfo;

public class ObserveController {
    public ServerInfo create(Request request, Response response){


        return new ServerInfo().setPath("sds");
    }
}
