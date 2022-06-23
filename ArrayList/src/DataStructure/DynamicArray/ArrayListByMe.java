package DataStructure.DynamicArray;

import java.util.Iterator;

public class ArrayListByMe<T> implements Iterable<T> {
    private T[] array;
    private int capacity;
    private int size;

    public ArrayListByMe() {
        this.array = (T[]) new Object[0];
    }

    public ArrayListByMe(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T getValueAt(int index){
        if (index < 0) throw new IllegalArgumentException("Index can not be negative");
        return array[index];
    }

    public void setValueAt(int index, T element) {
        array[index] = element;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void add(T element) {
        if (size >= capacity - 1) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null & element == null) return i;
            else if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T element) {
        int removeIndex = indexOf(element);
        if (removeIndex < 0) throw new IndexOutOfBoundsException();
        T[] newArray = (T[]) new Object[size - 1];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == removeIndex) {
                j--;
            } else {
                newArray[j] = array[i];
            }
        }
        array = newArray;
        capacity = --size;
    }

    public void removeLast() {
        array[size - 1] = null;
        size--;
    }

    public void insert(T insertData, int insertIndex) {
        if (insertIndex < 0 || insertIndex >= size) throw new IndexOutOfBoundsException();
        if (size >= capacity - 1) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
        }
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i == insertIndex) {
                newArray[j] = insertData;
                newArray[j+1] = array[i];
                j++;
            } else {
                newArray[j] = array[i];
            }
        }
        array = newArray;
        size++;
    }

    public boolean contain(T element){
        if (indexOf(element) != -1 ) return true;
        else return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                index++;
                return array[index - 1];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append('[');
            for (int i = 0; i < size - 1 ; i++) {
                sb.append((array[i])).append(",");
            }
            sb.append(array[size - 1]).append("]");
            return sb.toString();
        }
    }
}
