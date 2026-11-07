public class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        
        busiestRow(grid);
    }

    public static void busiestRow(int[][] grid) {
        int maxTotal = -1;
        int bestRowIndex = 0;

        for (int i = 0; i < grid.length; i++) {
            int currentSum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentSum += grid[i][j];
            }
            
            // Strictly greater ensures the tie-breaker keeps the smaller index
            if (currentSum > maxTotal) {
                maxTotal = currentSum;
                bestRowIndex = i;
            }
        }

        System.out.println("Row " + bestRowIndex + ", Total " + maxTotal);
    }
}