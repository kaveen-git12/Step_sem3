import java.util.Arrays;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) {
            return;
        }

        // Start from the second book (index 1)
        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;

            // Shift elements of books[0..i-1] that are greater than key to one position ahead
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }

            // Insert key into its correct spot
            books[j + 1] = key;

            // Print array state after placing each book from index 1 onwards
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        // Sample Input
        int[] books1 = {30, 10, 40, 20};
        shelf(books1);

        System.out.println();

        // Custom Test Case
        int[] books2 = {50, 20, 10, 30};
        shelf(books2);
    }
}