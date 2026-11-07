import java.util.Arrays;

public class DiceTallySorter {

    public static int[] diceSort(int[] rolls) {
        // Step 1: Use an array of size 7 to count occurrences of values 1 to 6
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }

        // Step 2: Print the counts in the requested format (1:count 2:count ...)
        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.print(v + ":" + count[v] + (v < 6 ? " " : "\n"));
        }

        // Step 3: Rebuild the sorted array using the tally counts
        int[] sortedRolls = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            while (count[v] > 0) {
                sortedRolls[index++] = v;
                count[v]--;
            }
        }

        System.out.println("Sorted: " + Arrays.toString(sortedRolls));
        return sortedRolls;
    }

    public static void main(String[] args) {
        // Sample Input
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        diceSort(rolls1);

        // Custom Test Case
        int[] rolls2 = {6, 5, 2, 3, 3, 1, 6, 2};
        diceSort(rolls2);
    }
}