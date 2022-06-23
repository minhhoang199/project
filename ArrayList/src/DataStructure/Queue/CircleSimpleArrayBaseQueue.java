package DataStructure.Queue;

import java.util.Iterator;

public class CircleSimpleArrayBaseQueue<T> implements QueueADT, Iterable {
    T[] array;
    int front;
    int end;
    //int size;

    public CircleSimpleArrayBaseQueue(int number) {
        this.array = (T[]) new Object[number];
        this.front = 0;
        this.end = -1;
        //this.size = number;
    }

    @Override
    public void enQueue(Object element) {
        if (end == -1) array[++end] = (T) element;
        else {
            if (end < front && end + 1 == front && array[end] != null) throw new RuntimeException("The Queue is full");
            if (front < end && end == array.length - 1 && array[end] != null)
                throw new RuntimeException("The Queue is full");
            if (++end == array.length) end = 0;
            array[end] = (T) element;
        }

    }

    @Override
    public Object deQueue() {
        if (isEmpty()) throw new RuntimeException("The Queue is empty");
        T deQueueElement = array[front];
        array[front] = null;//Ko cần care đến data ở front cũ;
        if (++front == array.length) front = 0;
        return deQueueElement;
    }

    @Override
    public Object first() {
        if (isEmpty()) throw new RuntimeException("The Queue is empty");
        return array[front];
    }

    @Override
    public int size() {
        if (end == -1) return 0;
        else if (end < front && end + 1 == front && array[end] == null) return 0;
        else if (front < end && end == array.length - 1 && array[end] == null) return 0;
        else if (front <= end) return end - front + 1;
        else return array.length - (front - end - 1);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
