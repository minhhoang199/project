package DataStructure.HashTable.HashSet;

public interface HashSetADT<T> {
    int hashFunction(T key);
    void add(T key);
    void remove(T key);
    boolean contains(T key);
}
