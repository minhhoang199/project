package HashTable;

import java.util.Random;

public class test {
    static final int Number_of_key = 10000000;
    static final int MOD = 10000000;
    static int[] keys = new int[Number_of_key];
    static int[] values = new int[Number_of_key];

    public static void main(String[] args) {
        Random rd = new Random();
        for (int i = 0; i <keys.length; i++){
            keys[i] = rd.nextInt() % MOD;
            values[i] = rd.nextInt() % MOD;
        }
        testSeparateChaining();
    }


    private static void testSeparateChaining(){
        HashTableADT<Integer, Integer> hashTable = new SeparateChainingHashTable<>(MOD);
        long start = System.nanoTime();
        for (int i = 0; i < Number_of_key; i++){
            hashTable.insert(keys[i], values[i]);
            int value = hashTable.get(keys[i]);
            if (value != values[i]) System.out.println("Code sai cmnr");
        }

        long end = System.nanoTime();
        System.out.println("Separate time " + (end - start)/Math.pow(10, 9));
    }
}
