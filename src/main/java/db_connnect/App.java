package db_connnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App 
{
    // Database URL, username, and password
    private static final String DB_URL = "jdbc:h2:mem:testdb"; // In-memory H2 database URL
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main( String[] args )
    {

        try {
            // Load the JDBC driver (H2)
            Class.forName("org.h2.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Create a table and insert data
            String createTableSQL = "CREATE TABLE Users (id INT PRIMARY KEY, name VARCHAR(255))";
            statement.execute(createTableSQL);

            String insertDataSQL = "INSERT INTO Users VALUES (1, 'User1'), (2, 'User2')";
            statement.executeUpdate(insertDataSQL);

            // Execute a query
            String query = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
            
            System.out.println("**Program Executed Successfully**");

            //Closing Connection 
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
}
