package JVM;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class OutOfMemoryDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        while (true) {
            unsafe.allocateMemory(11111113434l);
        }

    }
}


