package DataStructure.Queue;

import Stack.LinkedList.DoublyLinkedListByMe;

import java.util.Iterator;

public class LinkedListBaseQueue<T> implements QueueADT, Iterable {
    DoublyLinkedListByMe<T> linkedList = new DoublyLinkedListByMe<>();

    public LinkedListBaseQueue() {}

    public LinkedListBaseQueue(T element) {
        enQueue(element);
    }

    @Override
    public void enQueue(Object element) {
        linkedList.addLast((T) element);
    }

    @Override
    public Object deQueue() {
        T element = linkedList.peekFirst();
        linkedList.removeFirst();
        return element;
    }

    @Override
    public Object first() {
        return linkedList.peekFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return linkedList.iterator();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
