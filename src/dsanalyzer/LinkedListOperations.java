package dsanalyzer;

import java.util.Scanner;

/**
 * Singly Linked List with insert (front/end/position), delete, search and display.
 * Records the number of steps taken by search for performance comparison.
 */
public class LinkedListOperations {

    // Node of the singly linked list
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;
    private int lastSearchSteps = 0;

    // O(1)
    public void insertAtFront(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // O(n)
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Position is 0-based. O(n)
    public boolean insertAtPosition(int position, int value) {
        if (position < 0 || position > size) {
            return false;
        }
        if (position == 0) {
            insertAtFront(value);
            return true;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
        return true;
    }

    // Deletes first occurrence of value. O(n)
    public boolean deleteByValue(int value) {
        if (head == null) {
            return false;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    // Returns 0-based position of value, or -1 if not found. O(n)
    public int search(int value) {
        int steps = 0;
        int index = 0;
        Node current = head;
        while (current != null) {
            steps++;
            if (current.data == value) {
                lastSearchSteps = steps;
                return index;
            }
            current = current.next;
            index++;
        }
        lastSearchSteps = steps;
        return -1;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        System.out.println(sb + " -> null");
        System.out.println("Size: " + size);
    }

    public int getSize() {
        return size;
    }

    public int getLastSearchSteps() {
        return lastSearchSteps;
    }

    // ---------- Submenu ----------
    public void runMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--------- LINKED LIST OPERATIONS ---------");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Return to Main Menu");
            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    insertAtFront(readInt(sc, "Enter value: "));
                    System.out.println("Inserted at front.");
                    break;
                case 2:
                    insertAtEnd(readInt(sc, "Enter value: "));
                    System.out.println("Inserted at end.");
                    break;
                case 3:
                    int pos = readInt(sc, "Enter position (0 to " + size + "): ");
                    int val = readInt(sc, "Enter value: ");
                    if (insertAtPosition(pos, val)) {
                        System.out.println("Inserted at position " + pos + ".");
                    } else {
                        System.out.println("Invalid position. Must be between 0 and " + size + ".");
                    }
                    break;
                case 4:
                    if (head == null) {
                        System.out.println("List is empty. Nothing to delete.");
                    } else if (deleteByValue(readInt(sc, "Enter value to delete: "))) {
                        System.out.println("Value deleted.");
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;
                case 5:
                    if (head == null) {
                        System.out.println("List is empty.");
                    } else {
                        int target = readInt(sc, "Enter value to search: ");
                        int index = search(target);
                        if (index >= 0) {
                            System.out.println("Found at position " + index
                                    + " (steps: " + lastSearchSteps + ")");
                        } else {
                            System.out.println("Not found (steps: " + lastSearchSteps + ")");
                        }
                    }
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-7.");
            }
        } while (choice != 7);
    }

    private int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
}