package HashTable;

import DataStructure.DoublyLinkedList.DoublyLinkedListByMe;
import DataStructure.DoublyLinkedListByMe2.DoublyLinkedList.DoublyLinkedListByMe2;


import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SeparateChainingHashTable<K, V> implements HashTableADT<K, V> {
    private DoublyLinkedListByMe<Node<K, V>>[] table;
    private final int DEFAULT_CAPACITY = 10;
    private final double DEFAULT_LOAD_FACTOR = 0.5;

    private int size = 0, capacity, threshold;
    private double loadFactor;

    public SeparateChainingHashTable() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = DEFAULT_CAPACITY;
        this.threshold = (int) (this.capacity * loadFactor);
        table = new DoublyLinkedListByMe[capacity];
    }

    public SeparateChainingHashTable(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Invalid capacity");
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.threshold = (int) (this.capacity * loadFactor);
        table = new DoublyLinkedListByMe[capacity];
    }

    public SeparateChainingHashTable(int capacity, double loadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Invalid capacity");
        if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isFinite(loadFactor))
            throw new IllegalArgumentException("Invalid load factor");

        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.threshold = (int) (this.capacity * loadFactor);
        this.loadFactor = loadFactor;
        table = new DoublyLinkedListByMe[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int hashCodeToIndex(int hashedKey) {
        if (hashedKey < 0) {
            hashedKey = hashedKey * -1;
        }
        return hashedKey % capacity;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public boolean containKey(K key) {
        int index = hashCodeToIndex(key.hashCode());
        if (table[index].isEmpty()|| table[index] == null) return false;
        Iterator<Node<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = hashCodeToIndex(key.hashCode());
        if (table[index].isEmpty()|| table[index] == null) return null;
        Iterator<Node<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }

    @Override
    public V insert(K key, V value) {
        int index = hashCodeToIndex(key.hashCode());
        if (table[index] == null)table[index] = new DoublyLinkedListByMe<>();

        Node<K, V> existedNode = null;
        Iterator<Node<K, V>> iterator = table[index].iterator();

        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)) {
                existedNode = node;
            }
        }

        if (existedNode == null) {
            table[index].addLast(new Node<>(key, value));
            if (++size > threshold) reSize();
            return null;
        }
        else {
            V oldValue = existedNode.getValue();
            existedNode.setValue(value);
            return oldValue;
        }
    }

    private void reSize() {
        capacity *= 2;
        this.threshold = (int) (this.capacity * loadFactor);
        DoublyLinkedListByMe[] newTable = new DoublyLinkedListByMe[capacity];

        for (int i = 0; i < table.length; i++){
            if (table[i]== null) continue;

            Iterator<Node<K, V>> iterator = table[i].iterator();
            while (iterator.hasNext()) {
                Node<K, V> node = iterator.next();
                int index = hashCodeToIndex(node.getHashCode());
                if (newTable[index] == null){
                    newTable[index] = new DoublyLinkedListByMe();
                    newTable[index].addLast(node);
                }
            }
            table[i].clear();
            table[i] = null;
        }

        table = newTable;
    }

    @Override
    public V remove(K key) {
        int index = hashCodeToIndex(key.hashCode());

        Iterator<Node<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()){
            Node<K, V> node = iterator.next();
            if (node.getKey().equals(key)){
                table[index].remove(node);
                size--;
                return node.getValue();
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        final int elementCount = size();
        return new Iterator<K>() {
            int index = 0;
            Iterator<Node<K, V>> bucketIterator = table[index] == null? null:table[index].iterator();
            @Override
            public boolean hasNext() {
                if (elementCount != size) throw new ConcurrentModificationException("Size have changed");

                if (bucketIterator == null|| !bucketIterator.hasNext()){
                    while (++index < capacity){
                        if (table[index] != null||!table[index].isEmpty()){
                            bucketIterator = table[index].iterator();
                            break;
                        }
                    }
                }
                return index < capacity;
            }

            @Override
            public K next() {
                return bucketIterator.next().getKey();
            }
        };
    }
}
