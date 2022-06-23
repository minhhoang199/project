package DataStructure.HashTable.HashSet;

public interface HashMapADT<T, V> {
    int hashFunction(T key);
    void put(T key, V value);
    void remove(T key);
    void get(T key);
}
