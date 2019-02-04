package gc;

import java.util.ArrayList;
import java.util.List;

public class ss {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i, String.valueOf(i));
        }

        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("3")) {
                iterator.remove();
            }
        }*/

       /* for (int i = 0; i < 10; i++) {
            if (list.get(i).equals("3")) {
                list.remove(i);
            }

        }*/

        for (String s : list) {
            if (s.equals("3")) {
                list.remove(s);
            }
        }

        System.out.println(list);
    }
}
