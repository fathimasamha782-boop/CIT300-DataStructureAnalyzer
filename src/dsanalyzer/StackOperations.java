
package dsanalyzer;

public class StackOperations {

    private int[] stack = new int[100];
    private int top = -1;

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full!");
            return;
        }

        stack[++top] = value;
        System.out.println(value + " pushed onto stack.");
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Nothing to pop.");
            return;
        }

        System.out.println("Removed: " + stack[top--]);
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top element: " + stack[top]);
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

public void runMenu(java.util.Scanner input) {
    int choice;

    do {
        System.out.println("\n===== STACK MENU =====");
        System.out.println("1. Push");
        System.out.println("2. Pop");
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
                push(input.nextInt());
                break;

            case 2:
                pop();
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

