package dsanalyzer;

public class SearchOperations {

    // Holds the outcome of one search (used for the performance comparison)
    public static class SearchResult {
        private final String algorithm;
        private final int index;       // -1 means not found
        private final int steps;       // number of comparisons made
        private final long timeNanos;

        public SearchResult(String algorithm, int index, int steps, long timeNanos) {
            this.algorithm = algorithm;
            this.index = index;
            this.steps = steps;
            this.timeNanos = timeNanos;
        }

        public String getAlgorithm() {
            return algorithm;
        }

        public int getIndex() {
            return index;
        }

        public int getSteps() {
            return steps;
        }

        public long getTimeNanos() {
            return timeNanos;
        }

        public boolean isFound() {
            return index != -1;
        }
    }

    // Linear search: checks every element one by one - O(n)
    public static SearchResult linearSearch(int[] arr, int target) {
        int steps = 0;
        int foundIndex = -1;
        long start = System.nanoTime();

        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }

        long end = System.nanoTime();
        return new SearchResult("Linear Search", foundIndex, steps, end - start);
    }

    // Binary search: halves the search range each step - O(log n)
    // The array MUST be sorted in ascending order
    public static SearchResult binarySearch(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length - 1;
        int steps = 0;
        int foundIndex = -1;
        long start = System.nanoTime();

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] == target) {
                foundIndex = mid;
                break;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long end = System.nanoTime();
        return new SearchResult("Binary Search", foundIndex, steps, end - start);
    }
}