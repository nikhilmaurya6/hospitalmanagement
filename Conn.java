import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;

    public Conn() {
        try {
            // Establishing connection
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital_management_system", 
                "root", 
                "nikhil"
            );

            // Creating a statement
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace(); // Prints error details if any issue occurs
        }
    }
}
