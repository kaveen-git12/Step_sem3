import java.util.Arrays;

public class RosterRotator {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        if (n == 0) return new String[0];

        // Reduce k to remove redundant full loops
        int effectiveK = k % n;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            result[newIndex] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names1, 2)));
        // Output: [D, E, A, B, C]

        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names2, 7)));
        // Output: [D, E, A, B, C]
    }
}