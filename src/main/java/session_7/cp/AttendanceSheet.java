public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String studentName) {
        if (isPresent(studentName)) {
            return; // Avoid duplicate entries
        }
        if (count < presentStudents.length) {
            presentStudents[count] = studentName;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }
}