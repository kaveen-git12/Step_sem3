public class Solution5 {
    public int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;

        int n = nums.length;
        k = k % n;
        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }
}