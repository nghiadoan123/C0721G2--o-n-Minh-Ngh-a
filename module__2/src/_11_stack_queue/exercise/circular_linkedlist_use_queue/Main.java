package _11_stack_queue.exercise.circular_linkedlist_use_queue;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.front = q.rear = null;

        q.enQueue(q, 14);
        q.enQueue(q, 22);
        q.enQueue(q, 6);

        q.displayQueue(q);

        System.out.printf(" Deleted value = %d", q.deQueue(q));
        System.out.printf(" Deleted value = %d", q.deQueue(q));
        // Remaining elements in Circular Queue
        q.displayQueue(q);

        q.enQueue(q, 9);
        q.enQueue(q, 20);
        q.displayQueue(q);
    }
}
