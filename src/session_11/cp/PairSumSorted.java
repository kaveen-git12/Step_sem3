public class PairSumSorted {
    public static class PairResult {
        public boolean found;
        public int val1;
        public int val2;

        public PairResult(boolean found, int val1, int val2) {
            this.found = found;
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    public static PairResult pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                return new PairResult(true, nums[left], nums[right]);
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new PairResult(false, 0, 0);
    }
}