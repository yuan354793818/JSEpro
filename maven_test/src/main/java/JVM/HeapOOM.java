package JVM;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            Thread.sleep(80);
            list.add(new OOMObject());
        }

    }
}
