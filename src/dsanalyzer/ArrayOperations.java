package dsanalyzer;

import java.util.Arrays;

public class ArrayOperations {

    private int[] data;
    private int size;

    public ArrayOperations(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        data = new int[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    // Insert a value at the end of the array
    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Error: Array is full. Cannot insert " + value + ".");
            return false;
        }
        data[size] = value;
        size++;
        System.out.println(value + " inserted at index " + (size - 1) + ".");
        return true;
    }

    // Insert a value at a given index (shifts elements to the right)
    public boolean insertAt(int index, int value) {
        if (isFull()) {
            System.out.println("Error: Array is full. Cannot insert " + value + ".");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("Error: Invalid position. Enter 0 to " + size + ".");
            return false;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        System.out.println(value + " inserted at index " + index + ".");
        return true;
    }

    // Delete the element at a given index (shifts elements to the left)
    public boolean deleteAt(int index) {
        if (isEmpty()) {
            System.out.println("Error: Array is empty. Nothing to delete.");
            return false;
        }
        if (index < 0 || index >= size) {
            System.out.println("Error: Invalid position. Enter 0 to " + (size - 1) + ".");
            return false;
        }
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println(removed + " deleted from index " + index + ".");
        return true;
    }

    // Delete the first occurrence of a value
    public boolean deleteValue(int value) {
        if (isEmpty()) {
            System.out.println("Error: Array is empty. Nothing to delete.");
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return deleteAt(i);
            }
        }
        System.out.println("Error: Value " + value + " not found.");
        return false;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array (" + size + "/" + data.length + "): [");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Returns a copy of the stored elements (used by the search methods)
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    // Sorts the stored elements in ascending order (binary search needs this)
    public void sort() {
        Arrays.sort(data, 0, size);
    }

    public boolean isSorted() {
        for (int i = 1; i < size; i++) {
            if (data[i - 1] > data[i]) {
                return false;
            }
        }
        return true;
    }

    // Replaces the contents with n sample values: 2, 4, 6, ... 2n
    public void fillSample(int n) {
        if (n < 1 || n > data.length) {
            System.out.println("Error: n must be between 1 and " + data.length + ".");
            return;
        }
        for (int i = 0; i < n; i++) {
            data[i] = (i + 1) * 2;
        }
        size = n;
        System.out.println("Array filled with " + n + " sample values (2, 4, 6, ...).");
    }
}