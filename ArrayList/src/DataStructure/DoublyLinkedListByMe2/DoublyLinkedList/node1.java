package DataStructure.DoublyLinkedListByMe2.DoublyLinkedList;

public class node1<T, V> {
    private T key;
    private V value;
    private node1<T, V> prev, next;

    public node1(T key, V value, node1<T, V> prev, node1<T, V> next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setPrev(node1<T, V> prev) {
        this.prev = prev;
    }

    public void setNext(node1<T, V> next) {
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public node1<T, V> getPrev() {
        return prev;
    }

    public node1<T, V> getNext() {
        return next;
    }
}
