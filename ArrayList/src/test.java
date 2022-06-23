import Stack.LinkedListBaseStack;
import Stack.StackADT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        //ArrayListByMe <Integer> arr1 = new ArrayListByMe<>();
//        arr1.add(13);
//        arr1.add(14);
//        arr1.add(17);
//        arr1.add(18);
//        arr1.add(19);
//        arr1.add(20);
//        System.out.println(arr1.toString());
//        System.out.println("size" + arr1.size());
//        System.out.println("isEmpty" + arr1.isEmpty());
//        System.out.println("getValueAt: " + arr1.getValueAt(2));
//        System.out.println(arr1.indexOf(13));
//        arr1.remove(13);
//        arr1.insert(21, 3);
//
//        System.out.println(arr1.toString());
//        int number = 10000000;

        DoublyLinkedListByMe<Integer> linkedList = new DoublyLinkedListByMe<>();
//        long startTime1 = System.nanoTime();
//        for (int i = 0; i < number; i++){
//            linkedList.addLast(i);
//        }
//        for (int i = 0; i < number; i++){
//            linkedList.removeLast();
//        }
//        long endTime1 = System.nanoTime();
//        System.out.println("Total time of linkedListBaseStack:" + (endTime1 - startTime1));

        linkedList.addFirst(10);
        linkedList.addLast(1010);
        linkedList.remove(10);
    }
}

