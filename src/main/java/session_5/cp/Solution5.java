import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    private double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        // Composite score calculation: CGPA weighted out of 100 + Coding Score
        this.compositeScore = (cgpa * 10.0) + codingScore;
    }

    // Overloaded Check 1: CGPA-only quick filter (e.g., CGPA >= 7.5)
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Overloaded Check 2: Combined filter for borderline CGPA (e.g., CGPA >= 6.5 AND coding score >= 60)
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Sort descending by composite score for Arrays.sort(...)
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            // Check both overloaded eligibility conditions
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        // Convert to array and sort using standard Arrays.sort
        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        // Build output string formatted as "1. Aisha (102.0) | 2. Rohit (100.5) | ..."
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            sb.append(i + 1)
              .append(". ")
              .append(shortlistedArray[i].name)
              .append(" (")
              .append(shortlistedArray[i].compositeScore)
              .append(")");
              
            if (i < shortlistedArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }
}

public class Solution5 {
    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(Candidate.shortlistAndRank(candidates));
        // Output: 1. Aisha (122.0) | 2. Rohit (133.0) | 3. Karan (95.0) sorted by composite score descending
    }
}