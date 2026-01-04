package librarymanagemant;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Database credentials - Update these if needed
    private static final String URL = "jdbc:mysql://localhost:3306/Library";
    private static final String USERNAME = "nahom";                    // Your MySQL username
    private static final String PASSWORD = "NahomKetema123@";         // Your MySQL password

    // Method to get a connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            
       
          // Establish connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the Library database successfully!");
            
        } catch (SQLException e) {
            System.err.println("Connection failed! Check output below:");
            e.printStackTrace();
        }
        
        return connection;
    }

    // Test the connection (Main method)
    public static void main(String[] args) {
        Connection conn = getConnection();
        
        // Close connection if opened
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}