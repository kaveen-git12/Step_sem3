import java.util.Arrays;

public class InPlaceReversal {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44};
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(arr));
    }
}