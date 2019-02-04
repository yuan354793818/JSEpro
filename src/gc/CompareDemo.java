package gc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareDemo {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("xixi", 2));
        list.add(new User("guagua", 7));
        list.add(new User("feiji", 5));
        list.add(new User("meige", 1));
        UserComparator userComparator = new UserComparator();
        Object[] array =  list.toArray();
        Arrays.sort(array, userComparator);
        for (Object o : array) {
            System.out.println(o);
        }
    }
}


class UserComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        User u1 = null;
        User u2 = null;

        u1 = (User) o1;
        u2 = (User) o2;

        if (u1.getLevel() > u2.getLevel()) {
            return 1;
        } else if (u1.getLevel() < u2.getLevel()) {
            return -1;
        } else {
            return 0;
        }
    }
}


class User {
    private String name;
    private int level;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}