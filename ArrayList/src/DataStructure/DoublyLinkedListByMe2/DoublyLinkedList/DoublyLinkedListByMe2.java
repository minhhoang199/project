package DataStructure.DoublyLinkedListByMe2.DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedListByMe2<T, V> implements Iterable<T> {
    private int size;
    private node1<T, V> head = null;
    private node1<T, V> tail = null;

    //clear a list
    public void clear() {
        node1<T, V> currentNode = head;
        while (currentNode != null) {
            node1<T, V> nextNode = currentNode.getNext();
            currentNode.setPrev(null);
            currentNode.setKey(null);
            currentNode.setValue(null);
            currentNode.setNext(null);
            currentNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }


    //get size
    public int size() {
        return size;
    }

    //check a list is empty or not
    public boolean isEmpty() {
        return size() == 0;
    }


    //add a tail
    public void addLast(T key, V value) {
        if (isEmpty()) {
            head = tail = new node1<T, V>(key, value, null, null);
        } else {
            node1<T, V> newNode = new node1<T, V>(key, value, tail, null);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    //Add a head
    public void addFirst(T key, V value) {
        if (isEmpty()) {
            head = tail = new node1<T, V>(key, value, null, null);
        } else {
            node1<T, V> newNode = new node1<T, V>(key, value, null, head);
            head.setPrev(newNode);
            head = head.getPrev();
        }
        size++;
    }

    //Check index of an object
    public int indexOf(T key) {
        int index = 0;
        if (key == null) {
            for (node1<T, V> x = head; x != null; x = x.getNext()) {
                if (x.getKey() == null)
                    return index;
                index++;
            }
        } else {
            for (node1<T, V> x = head; x != null; x = x.getNext()) {
                if (x.getKey().equals(key))
                    return index;
                index++;
            }
        }
        return -1;
    }


    //Insert a node1 at an index
    public void insert(T key, V value, int insertIndex) {
        if (insertIndex >= size || insertIndex < 0) throw new IllegalArgumentException();
        if (isEmpty()) {
            head = tail = new node1<T, V>(key, value, null, null);
        } else {
            if (insertIndex == 0) {
                addFirst(key, value);
            } else if (insertIndex == size) {
                addLast(key, value);
            } else {
                if (insertIndex < size / 2) {
                    int index = 0;
                    for (node1<T, V> x = head; index < size / 2; x = x.getNext()) {
                        if (index == insertIndex) {
                            node1<T, V> newNode = new node1<>(key, value, x.getPrev(), x);
                            x.getPrev().setNext(newNode);
                            x.setPrev(newNode);
                            break;
                        }
                        index++;
                    }

                } else {
                    int index = size - 1;
                    for (node1<T, V> x = tail; index >= size / 2; x = x.getPrev()) {
                        if (index == insertIndex) {
                            node1<T, V> newNode = new node1<T, V>(key, value, x.getPrev(), x);
                            x.getPrev().setNext(newNode);
                            x.setPrev(newNode);
                            break;
                        }
                        index--;
                    }
                }
            }
        }
        size++;
    }


    //peek data at head node1
    public node1<T, V> peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        return head;
    }


    //peek data at tail node1
    public node1<T, V> peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        return tail;
    }

    //remove head
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        T data = head.getKey();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        else head.setPrev(null);
        return data;
    }

    //remove tail
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        T data = tail.getKey();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) head = null;
        else tail.setNext(null);
        return data;
    }

    //Remove a node1
    private T remove(node1<T, V> node) {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        if (node.equals(head)) {
            return removeFirst();
        } else if (node.equals(tail)) {
            return removeLast();
        }

        T data = node.getKey();

        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());

        node.setNext(null);
        node.setValue(null);
        node.setKey(null);
        node.setPrev(null);
        node = null;
        size--;

        return data;
    }

    //Remove an object
    public boolean remove(T key) {
        if (key == null) {
            for (node1<T, V> currentNode = head; currentNode.getNext() != null||currentNode == head; currentNode = currentNode.getNext()) {
                if (currentNode.getKey() == null) {
                    remove(currentNode);
                    return true;
                }
            }
        } else {
            for (node1<T, V> currentNode = head; currentNode.getNext() != null||currentNode == head; currentNode = currentNode.getNext()) {
                if (currentNode.getKey().equals(key)) {
                    remove(currentNode);
                    return true;
                }
            }
        }
        return false;
    }

    //remove at index
    public void removeAt(int removeIndex) {
        if (removeIndex >= size() || removeIndex < 0) throw new IllegalArgumentException();
        if (removeIndex == 0) removeFirst();
        else if (removeIndex == size - 1) removeLast();

        else {
            if (removeIndex < size / 2) {
                int index = 0;
                for (node1<T, V> currentNode = head; index != removeIndex + 1; currentNode = currentNode.getNext()) {
                    if (index == removeIndex) {
                        remove(currentNode);
                    }
                    index++;
                }
            } else {
                int index = size - 1;
                for (node1<T, V> currentNode = tail; index != removeIndex - 1; currentNode = currentNode.getPrev()) {
                    if (index == removeIndex) {
                        remove(currentNode);
                    }
                    index--;
                }
                size--;
            }
        }
    }

    public node1<T, V> getAtIndex(int index){
        int count = 0;
        for (node1<T, V> currentNode = head; currentNode != null; currentNode = currentNode.getNext()){
            if (count == index){
                return currentNode;
            }
            count++;
        }

        return null;
    }


    //Check list contains an object or not
    public boolean contain(T key) {
        return indexOf(key) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            node1<T, V> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.getKey();
                currentNode = currentNode.getNext();
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append('[');
            for (node1<T, V> currentNode = head; currentNode.getNext() != null; currentNode = currentNode.getNext()) {
                sb.append(currentNode.getKey()).append(":");
                sb.append(currentNode.getValue()).append(";");
            }
            sb.append(tail.getKey()).append(":");
            sb.append(tail.getValue()).append("]");
            return sb.toString();
        }
    }
}
