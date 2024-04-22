import java.util.regex.Pattern;

public class Pass {
    public boolean isValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        String uppercasePattern = "(?=.*[A-Z].*[A-Z])";
        String lowercasePattern = "(?=.*[a-z].*[a-z].*[a-z])";
        String digitPattern = "(?=.*[0-9])";
        String specialCharPattern = "(?=.*[!@#\\$%\\^&\\*\\^-])";

        String combinedPattern = "^" + uppercasePattern + lowercasePattern + digitPattern + specialCharPattern + ".*$";

        boolean isValid = Pattern.matches(combinedPattern, password);

        return isValid;
    }
}
