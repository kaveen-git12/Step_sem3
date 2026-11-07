import java.util.HashSet;
import java.util.Set;

public class TransactionCheck {
    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (seen.contains(id)) {
                return true;
            }
            seen.add(id);
        }
        return false;
    }
}