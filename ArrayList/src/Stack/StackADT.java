package Stack;

public interface StackADT<T> {
    void push(T element);
    void pop();
    T top();
    boolean isEmpty();
    int size();
}
