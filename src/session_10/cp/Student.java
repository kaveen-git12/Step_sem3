class Student {
    String name;
    int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double getAverage() {
        double sum = 0;
        for (int m : marks) sum += m;
        return sum / marks.length;
    }

    public char getGrade() {
        double avg = getAverage();
        if (avg >= 75) return 'B';
        else if (avg >= 40) return 'D';
        else return 'F';
    }

    public void printResultCard() {
        System.out.printf("%s: Average %.1f, Grade %c%n", 
            name.toUpperCase(), getAverage(), getGrade());
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});
        
        s1.printResultCard();
        s2.printResultCard();
    }
}