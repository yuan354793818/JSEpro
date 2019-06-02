package restexpress.controller;

import org.restexpress.Request;
import org.restexpress.Response;
import restexpress.bean.ClientInfo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class KeepAliveController {
    public ClientInfo create(Request request, Response response) {
        InetAddress localHost = null;
        try {
           localHost=InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return new ClientInfo().setPath(localHost.toString());
    }
}
