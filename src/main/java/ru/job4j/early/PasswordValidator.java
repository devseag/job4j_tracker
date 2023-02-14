package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        char[] symbols = password.toCharArray();
        boolean isDigital = false;
        boolean isUpper = false;
        boolean isLower = false;
        boolean isLetterOrDigital = false;
        for (char ch : symbols) {
            if (isDigit(ch)) {
                isDigital = true;
            } else if (isUpperCase(ch)) {
                isUpper = true;
            } else if (isLowerCase(ch)) {
                isLower = true;
            } else if (!isLetterOrDigit(ch)) {
                isLetterOrDigital = true;
            }
        }
        if (!isDigital) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isUpper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isLower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isLetterOrDigital) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (hasSubstringsAbuseWords(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean hasSubstringsAbuseWords(String pass) {
        String[] abuseWords = {"qwerty", "12345", "password", "admin", "user"};
        for (String aw : abuseWords) {
            if (pass.toLowerCase().contains(aw)) {
                return true;
            }
        }
        return false;
    }
}
