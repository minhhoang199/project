package DataStructure.HashTable.HashSet;

public class Main {
    public static void main(String[] args) {
        MyHashMapInt mhmi = new MyHashMapInt();
        mhmi.put(1);
        mhmi.put(1);
        mhmi.put(1001);
        mhmi.put(1001);
        mhmi.put(10);
        mhmi.put(1001);


        int index = mhmi.hashFunction(1);
        System.out.println(mhmi.get(1001));
        System.out.println(mhmi.getBuckets()[index]);
        System.out.println(mhmi.get(12));
    }
}
