package DataStructure.Queue;

public class testQueue {
    public static void main(String[] args) {
        CircleSimpleArrayBaseQueue<Integer> queue1 = new CircleSimpleArrayBaseQueue<Integer>(4);
        queue1.enQueue(10);
        queue1.enQueue(11);
        queue1.enQueue(12);
        queue1.enQueue(13);
        queue1.deQueue();
        queue1.deQueue();
        queue1.deQueue();
        queue1.enQueue(13);
        queue1.deQueue();
        queue1.deQueue();
        System.out.println(queue1.size());
        System.out.println(queue1.isEmpty());
    }
}
