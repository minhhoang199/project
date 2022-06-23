package DataStructure.DoublyLinkedList;

public class node<T> {
    private T data;
    private node<T> prev, next;

    public node(T data, node<T> prev, node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public node<T> getPrev() {
        return prev;
    }

    public node<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setPrev(node<T> prev) {
        this.prev = prev;
    }

    public void setNext(node<T> next) {
        this.next = next;
    }
}
