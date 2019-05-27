package algorithm;

public class MyCircularQueue {

    private int[] vals;
    private int start;
    private int end;
    private int len;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        vals = new int[k+1]; //多一位因为full时，有一位没使用
        len=k+1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }else {
            vals[end]=value;
            end=(end+1)%len;
            return  true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }else {
            start = (start + 1) % len;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return vals[start];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return vals[(end+len-1)%len];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return start==end;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (end+1)%len==start;
    }
}
