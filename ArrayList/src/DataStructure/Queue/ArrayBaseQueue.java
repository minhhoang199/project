package DataStructure.Queue;

import Stack.DynamicArray.ArrayListByMe;

import java.util.Iterator;

public class ArrayBaseQueue<T> implements QueueADT, Iterable {
    private ArrayListByMe<T> array;

    public ArrayBaseQueue(int capacity) {
        this.array = new ArrayListByMe<>(capacity);
    }

    public ArrayBaseQueue() {}

    @Override
    public void enQueue(Object element) {
         array.add((T)element);
    }

    @Override
    public Object deQueue() {
        T element = array.getValueAt(0);
        array.remove(element);
        return element;
    }

    @Override
    public Object first() {
        return array.getValueAt(0);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return array.iterator();
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
