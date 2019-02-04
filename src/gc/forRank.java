package gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class forRank {
    public static void main(String[] args) throws IOException {
        BufferedReader bd = new BufferedReader(new FileReader("C:\\Users\\YJY.DESKTOP-KNFMEQ7\\Desktop\\items.txt"));
        String buf;
        List<Item> list = new ArrayList<>();
        Item item=null;
        while ((buf=bd.readLine())!=null) {
            String[] split = buf.split(",");
            item=new Item(split[0],Integer.parseInt(split[1]));
            list.add(item);
        }

        forRank.rank(list);
        System.out.println("__________________________");
        System.out.println(list);
    }

    public static void rank(List<Item> list) {

        Item buf = null;
        for (int i = 0; i < list.size(); i++) {
            buf = list.get(i);
            for (int j = i+1; j< list.size(); j++) {
                if (list.get(j).getPrice() > buf.getPrice()) {
                    buf = list.get(j);
                }
            }
            int max = list.indexOf(buf);
            Item item = list.get(i);
            list.remove(max);
            list.add(max, item);

            list.remove(i);
            list.add(i,buf);
        }
    }


}


class Item{
    private String name;
    private int price;


    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}