
package dsanalyzer;

public class QueueOperations {

    private int[] queue = new int[100];
    private int front = 0;
    private int rear = -1;
    private int count = 0;

    public void enqueue(int value) {
        if (count == queue.length) {
            System.out.println("Queue is full!");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        count++;

        System.out.println(value + " added to the queue.");
    }

    public void dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty. Nothing to remove.");
            return;
        }

        System.out.println("Removed: " + queue[front]);

        front = (front + 1) % queue.length;
        count--;
    }

    public void peek() {
        if (count == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Front element: " + queue[front]);
    }

    public void display() {
        if (count == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue (front to rear):");

        for (int i = 0; i < count; i++) {
            int index = (front + i) % queue.length;
            System.out.println(queue[index]);
        }
    }

public void runMenu(java.util.Scanner input) {
    int choice;

    do {
        System.out.println("\n===== QUEUE MENU =====");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek");
        System.out.println("4. Display");
        System.out.println("0. Return to Main Menu");
        System.out.print("Enter your choice: ");

        while (!input.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            input.next();
        }

        choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter value: ");
                while (!input.hasNextInt()) {
                    System.out.print("Enter a valid number: ");
                    input.next();
                }
                enqueue(input.nextInt());
                break;

            case 2:
                dequeue();
                break;

            case 3:
                peek();
                break;

            case 4:
                display();
                break;

            case 0:
                System.out.println("Returning to Main Menu...");
                break;

            default:
                System.out.println("Invalid choice. Try again.");
        }
    } while (choice != 0);
}

}

