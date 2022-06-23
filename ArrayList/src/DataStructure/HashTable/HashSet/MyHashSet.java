package DataStructure.HashTable.HashSet;

import DataStructure.DoublyLinkedList.DoublyLinkedListByMe;

public class MyHashSet<T> implements HashSetADT {
     private final int size = 1000;
     private DoublyLinkedListByMe<T>[] buckets;

    public MyHashSet() {
        this.buckets = new DoublyLinkedListByMe[size];
        for (int i = 0; i < size; i++){
            buckets[i] = new DoublyLinkedListByMe<T>();
        }
    }

    //return key value


    @Override
    public int hashFunction(Object key) {
        return (int)key % size;
    }

    @Override
    public void add(Object key) {
        int hashValueIndex = hashFunction(key);
        if(!buckets[hashValueIndex].contain(key)){
            buckets[hashValueIndex].addLast((T)key);
        }

    }

    @Override
    public void remove(Object key) {
        int hashValueIndex = hashFunction(key);
        var bucket = buckets[hashValueIndex];
        if(bucket.contain(key)) {
            buckets[hashValueIndex].remove(key);
        }
    }

    @Override
    public boolean contains(Object key) {
        int hashValueIndex = hashFunction(key);
        var bucket = buckets[hashValueIndex];
        if(bucket.contain(key)){
            return true;
        }
        return false;
    }

    public DoublyLinkedListByMe<T>[] getBuckets() {
        return buckets;
    }

    public static void main(String[] args) {
        MyHashSet<Integer> set1 = new MyHashSet<>();
        set1.add(10);
        set1.add(1010);
        set1.add(1);
        set1.add(10);
        set1.remove(10);

        set1.remove(1);
        set1.add(10);

        System.out.println(set1.contains(1));
        System.out.println(set1.contains(10));
        System.out.println(set1.contains(1010));
    }
}
