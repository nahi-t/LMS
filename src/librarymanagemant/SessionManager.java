package librarymanagemant;

public class SessionManager {
    // Static variables stay in memory while the app is running
    public static String currentUsername;
    public static String fullName;
    public static String userRole;

    // Call this when login is successful
    public static void login(String username, String name, String role) {
        currentUsername = username;
        fullName = name;
        userRole = role;
    }

    // Call this for logout
    public static void logout() {
        currentUsername = null;
        fullName = null;
        userRole = null;
    }

}