package dsanalyzer;

import java.util.Scanner;

public class ArraySearchMenu {

    private final ArrayOperations array = new ArrayOperations(1000);
    private SearchOperations.SearchResult lastLinear;
    private SearchOperations.SearchResult lastBinary;

    // Used by the integrator for the Performance Comparison menu
    public SearchOperations.SearchResult getLastLinear() {
        return lastLinear;
    }

    public SearchOperations.SearchResult getLastBinary() {
        return lastBinary;
    }

    public void runArrayMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert (at end)");
            System.out.println("2. Insert at position");
            System.out.println("3. Delete by value");
            System.out.println("4. Delete at position");
            System.out.println("5. Search (linear)");
            System.out.println("6. Display");
            System.out.println("7. Fill with sample data");
            System.out.println("8. Return to Main Menu");
            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    array.insert(readInt(sc, "Enter value: "));
                    break;
                case 2: {
                    int pos = readInt(sc, "Enter position: ");
                    int val = readInt(sc, "Enter value: ");
                    array.insertAt(pos, val);
                    break;
                }
                case 3:
                    array.deleteValue(readInt(sc, "Enter value to delete: "));
                    break;
                case 4:
                    array.deleteAt(readInt(sc, "Enter position to delete: "));
                    break;
                case 5: {
                    if (array.isEmpty()) {
                        System.out.println("Array is empty. Insert values first.");
                        break;
                    }
                    int target = readInt(sc, "Enter value to search: ");
                    printResult(SearchOperations.linearSearch(array.toArray(), target));
                    break;
                }
                case 6:
                    array.display();
                    break;
                case 7:
                    array.fillSample(readInt(sc,
                            "How many sample values? (1-" + array.getCapacity() + "): "));
                    break;
                case 8:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-8.");
            }
        } while (choice != 8);
    }

    public void runSearchMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Return to Main Menu");
            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1: {
                    if (array.isEmpty()) {
                        System.out.println("Array is empty. Insert values first.");
                        break;
                    }
                    int target = readInt(sc, "Enter value to search: ");
                    lastLinear = SearchOperations.linearSearch(array.toArray(), target);
                    printResult(lastLinear);
                    break;
                }
                case 2: {
                    if (array.isEmpty()) {
                        System.out.println("Array is empty. Insert values first.");
                        break;
                    }
                    prepareSorted();
                    int target = readInt(sc, "Enter value to search: ");
                    lastBinary = SearchOperations.binarySearch(array.toArray(), target);
                    printResult(lastBinary);
                    break;
                }
                case 3: {
                    if (array.isEmpty()) {
                        System.out.println("Array is empty. Insert values first.");
                        break;
                    }
                    prepareSorted();
                    int target = readInt(sc, "Enter value to search: ");
                    lastLinear = SearchOperations.linearSearch(array.toArray(), target);
                    lastBinary = SearchOperations.binarySearch(array.toArray(), target);
                    printComparison(lastLinear, lastBinary);
                    break;
                }
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-4.");
            }
        } while (choice != 4);
    }

    // Binary search needs a sorted array
    private void prepareSorted() {
        if (!array.isSorted()) {
            System.out.println("Note: Array was not sorted. Sorting it first "
                    + "(binary search needs a sorted array).");
            array.sort();
        }
    }

    private void printResult(SearchOperations.SearchResult r) {
        System.out.println("Algorithm : " + r.getAlgorithm());
        if (r.isFound()) {
            System.out.println("Result    : Found at index " + r.getIndex());
        } else {
            System.out.println("Result    : Not found");
        }
        System.out.println("Steps     : " + r.getSteps());
        System.out.println("Time      : " + r.getTimeNanos() + " ns");
    }

    private void printComparison(SearchOperations.SearchResult linear,
                                 SearchOperations.SearchResult binary) {
        System.out.println("\n=============================================");
        System.out.println(" SEARCH COMPARISON (array size = " + array.getSize() + ")");
        System.out.println("=============================================");
        System.out.printf("%-16s %-8s %-12s %s%n", "Algorithm", "Steps", "Time (ns)", "Result");
        System.out.println("------------------------------------------------");
        printRow(linear);
        printRow(binary);
        System.out.println("=============================================");
    }

    private void printRow(SearchOperations.SearchResult r) {
        String result = r.isFound() ? "Found at " + r.getIndex() : "Not found";
        System.out.printf("%-16s %-8d %-12d %s%n",
                r.getAlgorithm(), r.getSteps(), r.getTimeNanos(), result);
    }

    // Reads a whole number safely (no crash on wrong input)
    private int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    // Small test menu so you can run your own part alone
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArraySearchMenu menu = new ArraySearchMenu();
        int choice;
        do {
            System.out.println("\n===== ARRAY & SEARCH TEST MENU =====");
            System.out.println("1. Array Operations");
            System.out.println("2. Searching Operations");
            System.out.println("3. Exit");
            choice = menu.readInt(sc, "Enter your choice: ");

            if (choice == 1) {
                menu.runArrayMenu(sc);
            } else if (choice == 2) {
                menu.runSearchMenu(sc);
            } else if (choice != 3) {
                System.out.println("Invalid choice. Enter 1-3.");
            }
        } while (choice != 3);

        sc.close();
    }
}