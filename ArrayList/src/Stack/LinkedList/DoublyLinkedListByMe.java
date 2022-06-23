package Stack.LinkedList;

import java.util.Iterator;

public class DoublyLinkedListByMe<T> implements Iterable<T> {
    private int size;
    private node<T> head = null;
    private node<T> tail = null;

    //clear a list
    public void clear() {
        node<T> currentNode = head;
        while (currentNode != null) {
            node<T> nextNode = currentNode.getNext();
            currentNode.setPrev(null);
            currentNode.setData(null);
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
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new node<T>(element, null, null);
        } else {
            node<T> newNode = new node<>(element, tail, null);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    //Add a head
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new node<T>(element, null, null);
        } else {
            node<T> newNode = new node<>(element, null, head);
            head.setPrev(newNode);
            head = head.getPrev();
        }
        size++;
    }

    //Check index of an object
    public int indexOf(Object object) {
        int index = 0;
        if (object == null) {
            for (node<T> x = head; x != null; x = x.getNext()) {
                if (x.getData() == null)
                    return index;
                index++;
            }
        } else {
            for (node<T> x = head; x != null; x = x.getNext()) {
                if (x.getData().equals(object))
                    return index;
                index++;
            }
        }
        return -1;
    }


    //Insert a node1 at an index
    public void insert(T element, int insertIndex) {
        if (insertIndex >= size || insertIndex < 0) throw new IllegalArgumentException();
        if (isEmpty()) {
            head = tail = new node<T>(element, null, null);
        } else {
            if (insertIndex == 0) {
                addFirst(element);
            } else if (insertIndex == size) {
                addLast(element);
            } else {
                if (insertIndex < size / 2) {
                    int index = 0;
                    for (node<T> x = head; index < size / 2; x = x.getNext()) {
                        if (index == insertIndex) {
                            node<T> newNode = new node<>(element, x.getPrev(), x);
                            x.getPrev().setNext(newNode);
                            x.setPrev(newNode);
                            break;
                        }
                        index++;
                    }

                } else {
                    int index = size - 1;
                    for (node<T> x = tail; index >= size / 2; x = x.getPrev()) {
                        if (index == insertIndex) {
                            node<T> newNode = new node<>(element, x.getPrev(), x);
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
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        return head.getData();
    }


    //peek data at tail node1
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        return tail.getData();
    }

    //remove head
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        T data = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        else head.setPrev(null);
        return data;
    }

    //remove tail
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        T data = tail.getData();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) head = null;
        else tail.setNext(null);
        return data;
    }

    //Remove a node1
    public T remove(node<T> node) {
        if (isEmpty()) throw new RuntimeException("Empty linked list");
        if (node.getPrev() == null) removeFirst();
        else if (node.getNext() == null) removeLast();

        T data = node.getData();
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());

        node.setNext(null);
        node.setData(null);
        node.setPrev(null);
        node = null;
        size--;

        return data;
    }

    //Remove an object
    public boolean remove(Object object) {
        if (object == null) {
            for (node<T> currentNode = head; currentNode.getNext() != null; currentNode = currentNode.getNext()) {
                if (currentNode.getData() == null) {
                    remove(currentNode);
                    return true;
                }
            }
        } else {
            for (node<T> currentNode = head; currentNode.getNext() != null; currentNode = currentNode.getNext()) {
                if (currentNode.getData() == object) {
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
                for (node<T> currentNode = head; index != removeIndex + 1; currentNode = currentNode.getNext()) {
                    if (index == removeIndex) {
                        remove(currentNode);
                    }
                    index++;
                }
            } else {
                int index = size - 1;
                for (node<T> currentNode = tail; index != removeIndex - 1; currentNode = currentNode.getPrev()) {
                    if (index == removeIndex) {
                        remove(currentNode);
                    }
                    index--;
                }
                size--;
            }
        }
    }


    //Check list contains an object or not
    public boolean contain(Object object) {
        return indexOf(object) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.getData();
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
            for (node<T> currentNode = head; currentNode.getNext() != null; currentNode = currentNode.getNext()) {
                sb.append(currentNode.getData()).append(",");
            }
            sb.append(tail.getData()).append("]");
            return sb.toString();
        }
    }
}
