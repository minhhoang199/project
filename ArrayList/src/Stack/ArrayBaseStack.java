package Stack;

import Stack.DynamicArray.ArrayListByMe;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayBaseStack<T> implements StackADT, Iterable {
    private int index = -1;
    private ArrayListByMe<T> array;

    public ArrayBaseStack(int initSize) {
        array = new ArrayListByMe<>(initSize);
    }

    @Override
    public void push(Object element) {
        array.add((T) element);
        index++;
    }

    @Override
    public void pop() {
        if (isEmpty()) throw new EmptyStackException();
        array.removeLast();
        index--;
    }

    @Override
    public Object top() {
        return array.getValueAt(index);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public Iterator iterator() {
        return array.iterator();
    }
}
