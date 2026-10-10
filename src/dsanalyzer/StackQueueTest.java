
package dsanalyzer;

public class StackQueueTest {

    public static void main(String[] args) {

        StackOperations stack = new StackOperations();
        QueueOperations queue = new QueueOperations();

        System.out.println("===== STACK TEST =====");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.peek();
        stack.pop();
        stack.display();

        System.out.println("\n===== QUEUE TEST =====");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        queue.peek();
        queue.dequeue();
        queue.display();
    }
}
