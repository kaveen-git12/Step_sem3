public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int writeIdx = 1;
        for (int readIdx = 1; readIdx < nums.length; readIdx++) {
            if (nums[readIdx] != nums[readIdx - 1]) {
                nums[writeIdx] = nums[readIdx];
                writeIdx++;
            }
        }
        return writeIdx;
    }
}