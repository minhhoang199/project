package Stack;

import Stack.LinkedList.DoublyLinkedListByMe;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListBaseStack<T> implements StackADT, Iterable {
    private DoublyLinkedListByMe<T> linkedList = new DoublyLinkedListByMe<>();

    public LinkedListBaseStack(){}

    public LinkedListBaseStack(T element) {
        push(element);
    }

    @Override
    public void push(Object element) {
        linkedList.addFirst((T) element);
    }

    @Override
    public void pop() {
        if (isEmpty()) throw new EmptyStackException();
        linkedList.removeFirst();
    }

    @Override
    public Object top() {
        if (isEmpty()) throw new EmptyStackException();
        return linkedList.peekLast();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public Iterator iterator() {
        return linkedList.iterator();
    }
}
