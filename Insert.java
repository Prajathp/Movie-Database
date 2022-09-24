import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class Insert {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/Movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String Movie_Title, String Actor,String Actress,int Year_Of_Release,String Director) {
        String sql = "INSERT INTO Movies(Movie_Title,Actor,Actress,Year_Of_Release,Director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Movie_Title);
            pstmt.setString(2, Actor);
            pstmt.setString(3, Actress);
            pstmt.setInt(4, Year_Of_Release);
            pstmt.setString(5, Director);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Insert app = new Insert();
        // insert three new rows
        app.insert("K.G.F Chapter 1","Yash","Sri Nidhi",2018,"Prashanth Neel");
        app.insert("K.G.F Chapter 2","Yash","Sri Nidhi",2022,"Prashanth Neel");
        app.insert("Kotigobba 3","Sudeep","Shraddha das", 2021,"Shiiva Karthik");
        app.insert("Vikranth Rona","Sudeep","Neetha Ashok", 2022,"Anup Bhandari");
        app.insert("Charlie","Rakshith Shetty","Sangeetha", 2022,"Kiranraj K");
        
    }
}
