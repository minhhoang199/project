package DataStructure.HashTable.HashSet;

import DataStructure.DoublyLinkedListByMe2.DoublyLinkedList.DoublyLinkedListByMe2;

public class MyHashMapInt {
    private final int size = 1000;
    private DoublyLinkedListByMe2<Integer, Integer>[] buckets;

    public MyHashMapInt() {
        buckets = new DoublyLinkedListByMe2[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new DoublyLinkedListByMe2<>();
        }
    }

    public void setBuckets(DoublyLinkedListByMe2<Integer, Integer>[] buckets) {
        this.buckets = buckets;
    }

    public int getSize() {
        return size;
    }

    public DoublyLinkedListByMe2<Integer, Integer>[] getBuckets() {
        return buckets;
    }


    public int hashFunction(int key) {
        return (int) key % size;
    }

    public void put(int key) {
        int value = 1;
        int hashIndex = hashFunction(key);
        if (!buckets[hashIndex].contain(key)) {
            buckets[hashIndex].addLast(key, value);
        } else {
            int indexOfLinkedList = buckets[hashIndex].indexOf(key);
            value = buckets[hashIndex].getAtIndex(indexOfLinkedList).getValue();
            buckets[hashIndex].getAtIndex(indexOfLinkedList).setValue(value + 1);
        }
    }


    public void remove(int key) {
        int hashIndex = hashFunction(key);
        if (!buckets[hashIndex].contain(key)) {
            System.out.println("There is not this key in the list");
        }
        buckets[hashIndex].remove(key);
    }


    public int get(int key) {
        int hashIndex = hashFunction(key);
        if (buckets[hashIndex].contain(key)) {
            int indexOfLinkedList = buckets[hashIndex].indexOf(key);
            int value = buckets[hashIndex].getAtIndex(indexOfLinkedList).getValue();
            return value;
        }
        return -1;
    }
}
