import java.util.Arrays;

public class Solution1 {
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Double the captain's score (2x)
        playerScores[captainIndex] *= 2.0;
        
        // Multiply the vice-captain's score by 1.5
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores)); 
        // Output: [40.0, 110.0, 30.0, 93.0]
    }
}