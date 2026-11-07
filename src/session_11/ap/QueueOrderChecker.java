public class QueueOrderChecker {

    public static int firstBreak(int[] tokens) {
        // A queue with 0 or 1 student is always in order
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        // Compare each student's token with the one just before them
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i; // Return index of the first out-of-order student
            }
        }

        return -1; // Queue is fully in order
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(tokens1)); // Output: 4 (6 comes after 8)

        // Sample Input 2
        int[] tokens2 = {1, 2, 2, 7};
        System.out.println(firstBreak(tokens2)); // Output: -1

        // Custom Test Cases
        int[] tokens3 = {10};
        System.out.println(firstBreak(tokens3)); // Output: -1

        int[] tokens4 = {5, 4, 3, 2, 1};
        System.out.println(firstBreak(tokens4)); // Output: 1
    }
}