import java.util.ArrayList;
import java.util.List;

public class MatrixSpiral {
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid == null || grid.length == 0) return result;

        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse Left to Right
            for (int c = left; c <= right; c++) {
                result.add(grid[top][c]);
            }
            top++;

            // Traverse Top to Bottom
            for (int r = top; r <= bottom; r++) {
                result.add(grid[r][right]);
            }
            right--;

            // Traverse Right to Left
            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    result.add(grid[bottom][c]);
                }
                bottom--;
            }

            // Traverse Bottom to Top
            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    result.add(grid[r][left]);
                }
                left++;
            }
        }
        return result;
    }
}