package DataStructure.Queue;

public interface QueueADT<T> {
    void enQueue(T element);
    T deQueue();
    T first();
    int size();
    boolean isEmpty();
}
