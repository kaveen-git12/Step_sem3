import java.util.HashMap;
import java.util.Map;

class EmployeeRecord {
    String employeeId;
    String department;

    public EmployeeRecord(String employeeId, String department) {
        this.employeeId = employeeId;
        this.department = department;
    }
}

public class HRSystem {
    public static Map<String, String> buildLookup(EmployeeRecord[] records) {
        Map<String, String> lookup = new HashMap<>();
        for (EmployeeRecord record : records) {
            lookup.put(record.employeeId, record.department);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }
}