import java.util.Arrays;

public class PairSumTwoPointers {
    public static boolean hasPairWithSum(int[] nums, int target) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        int left = 0;
        int right = sorted.length - 1;

        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}