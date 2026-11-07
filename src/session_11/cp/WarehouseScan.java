public class WarehouseScan {
    public static class SummaryResult {
        public int total;
        public int maxRow;
        public int maxCol;

        public SummaryResult(int total, int maxRow, int maxCol) {
            this.total = total;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }
    }

    public static SummaryResult warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                // Using strictly greater (>) ensures ties keep the first encountered bin
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new SummaryResult(total, maxRow, maxCol);
    }
}