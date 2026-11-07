import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // Perform a sweep from left to right
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    // Swap adjacent elements
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            // Print the line state after the pass
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

            // If no swaps happened in this pass, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] h1 = {4, 2, 5, 1};
        lineUp(h1);

        System.out.println("\n--- Test Case 2 ---");
        int[] h2 = {1, 3, 2, 4};
        lineUp(h2);
    }
}