package db_connnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App 
{
    private static final String DB_URL = "jdbc:h2:mem:testdb"; // In-memory H2 database URL
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main( String[] args )
    {

        try {
            Class.forName("org.h2.Driver");
            
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
]
            Statement statement = connection.createStatement();

            String createTableSQL = "CREATE TABLE Users (id INT PRIMARY KEY, name VARCHAR(255))";
            statement.execute(createTableSQL);

            String insertDataSQL = "INSERT INTO Users VALUES (1, 'User1'), (2, 'User2')";
            statement.executeUpdate(insertDataSQL);
            
            String query = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
            
            System.out.println("**Program Executed Successfully**");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
}
