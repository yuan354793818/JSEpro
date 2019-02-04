package design_patterns;

public class IteratorDemo {
    public static void main(String[] args) {
        MyList<String> list=new MyList<String>();
        list.add("121");
        list.add("sdsd");
        list.add("xxxxx");
        MyIterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


class MyList<T> {

    private T[] elements = (T[]) new Object[1024];
    private int currIndex = 0;

    public void add(T t ) {
        elements[currIndex++]=t;
    }

    public MyIterator<T> iterator() {
        return new MyIterator<T>(elements,currIndex);
    }
}

class MyIterator<T>{
    private T[] elements;
    private int currSize;
    private int index=0;


    public MyIterator(T[] elements, int currSize) {
        this.elements = elements;
        this.currSize = currSize;
    }

    public boolean hasNext() {
        return index != currSize;
    }

    public T next() {
        return elements[index++];
    }
}


