import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();
    public abstract String getType();
}

class MCQQuestion extends Question {
    public MCQQuestion(String qText, String cAns, String sAns, double points) {
        super(qText, cAns, sAns, points);
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {
    public TFQuestion(String qText, String cAns, String sAns, double points) {
        super(qText, cAns, sAns, points);
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String qText, String cAns, String sAns, double points) {
        super(qText, cAns, sAns, points);
    }

    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAns = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            if (lowerStudentAns.contains(kw.trim().toLowerCase())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0.0;
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        List<Question> questions = new ArrayList<>();

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    tokens.add(matcher.group(1));
                } else {
                    tokens.add(matcher.group(2));
                }
            }

            String type = tokens.get(0);
            String qText = tokens.get(1);
            String cAns = tokens.get(2);
            String sAns = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            switch (type) {
                case "MCQ":
                    questions.add(new MCQQuestion(qText, cAns, sAns, points));
                    break;
                case "TF":
                    questions.add(new TFQuestion(qText, cAns, sAns, points));
                    break;
                case "ESSAY":
                    questions.add(new EssayQuestion(qText, cAns, sAns, points));
                    break;
            }
        }

        double totalScore = 0;
        for (Question q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
        sc.close();
    }
}