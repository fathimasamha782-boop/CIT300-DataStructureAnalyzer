package dsanalyzer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArraySearchMenu arraySearch = new ArraySearchMenu();
        int choice;

        do {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    arraySearch.runArrayMenu(sc);
                    break;
                case 2:
                    System.out.println("Stack module - coming soon.");
                    break;
                case 3:
                    System.out.println("Queue module - coming soon.");
                    break;
                case 4:
                    System.out.println("Linked List module - coming soon.");
                    break;
                case 5:
                    arraySearch.runSearchMenu(sc);
                    break;
                case 6:
                    System.out.println("Graph module - coming soon.");
                    break;
                case 7:
                case 8:
                    showPerformance(arraySearch);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-9.");
            }
        } while (choice != 9);

        sc.close();
    }

    // Shows the latest search comparison (Graph BFS/DFS rows can be added later)
    private static void showPerformance(ArraySearchMenu arraySearch) {
        SearchOperations.SearchResult linear = arraySearch.getLastLinear();
        SearchOperations.SearchResult binary = arraySearch.getLastBinary();

        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON");
        System.out.println("=============================================");

        if (linear == null || binary == null) {
            System.out.println("No search results yet.");
            System.out.println("Go to option 5 (Searching) -> 3 (Compare) first.");
            return;
        }

        System.out.printf("%-16s %-8s %-12s %s%n", "Algorithm", "Steps", "Time (ns)", "Result");
        System.out.println("------------------------------------------------");
        printRow(linear);
        printRow(binary);
        System.out.println("=============================================");
    }

    private static void printRow(SearchOperations.SearchResult r) {
        String result = r.isFound() ? "Found at " + r.getIndex() : "Not found";
        System.out.printf("%-16s %-8d %-12d %s%n",
                r.getAlgorithm(), r.getSteps(), r.getTimeNanos(), result);
    }

    private static int readInt(Scanner sc, String prompt) {
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