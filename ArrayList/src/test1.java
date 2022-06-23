import Stack.LinkedList.DoublyLinkedListByMe;

public class test1 {
    public static void main(String[] args) {
        DoublyLinkedListByMe<Integer> testList = new DoublyLinkedListByMe<Integer>();
        System.out.println(testList.toString());

        //add
        testList.addFirst(12);
        testList.addLast(14);
        testList.addFirst(11);
        testList.addLast(15);
        System.out.println(testList.toString());
        System.out.println("IndexOf:  " + testList.indexOf(11));
        System.out.println("IndexOf:  " + testList.indexOf(10));


//        testList.insert(10,1);
//        System.out.println(testList.toString());

//        System.out.println("Pick first  " + testList.peekFirst());
//        System.out.println("Pick last  " + testList.peekLast());

        //remove
        testList.removeAt(0);
        System.out.println(testList.toString());

        System.out.println(testList.contain(14));

    }
}
