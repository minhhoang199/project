package Stack;

public class testStack {
    public static void main(String[] args) {
        //array
        int number = 10000000;
        StackADT<Integer> arrayBaseStack = new ArrayBaseStack<Integer>(10000);
        long startTime = System.nanoTime();
        for (int i = 0; i < number; i++){
            arrayBaseStack.push(i);
        }
        for (int i = 0; i < number; i++){
            arrayBaseStack.pop();
        }
        long endTime = System.nanoTime();
        System.out.println("Total time of arrayBaseStack:" + (endTime - startTime));


        //linked list
        StackADT<Integer> linkedListBaseStack = new LinkedListBaseStack<>();

        long startTime1 = System.nanoTime();
        for (int i = 0; i < number; i++){
            linkedListBaseStack.push(i);
        }
        for (int i = 0; i < number; i++){
            linkedListBaseStack.pop();
        }
        long endTime1 = System.nanoTime();
        System.out.println("Total time of linkedListBaseStack:" + (endTime1 - startTime1));

    }

}
