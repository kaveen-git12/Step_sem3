public class Scorecard {
    private final boolean[] results;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < results.length) {
            results[recordedCount] = isCorrect;
            recordedCount++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}