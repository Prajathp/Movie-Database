import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


/**
 *
 * @author sqlitetutorial.net
 */
public class QueryWithParameter {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * select all rows in the warehouses table
     */
    public void getActor(String Actor){
        String sql = "SELECT * "
                   + "FROM Movies WHERE Actor=?";
 
 try (Connection conn = this.connect();
		 PreparedStatement pstmt  = conn.prepareStatement(sql)){
     
     // set the value
     pstmt.setString(1,Actor);
     //
     ResultSet rs  = pstmt.executeQuery();
     
     // loop through the result set
     while (rs.next()) {
         System.out.println(rs.getString("Movie_Title")+ "\t" +"\t" +
         		rs.getString("Actor")+"\t" +"\t" +
         		rs.getString("Actress")+"\t"+
         		rs.getInt("Year_Of_Release")+"\t" +
         		rs.getString("Director"));
     }
 } catch (SQLException e) {
     System.out.println(e.getMessage());
 }
}
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	QueryWithParameter app = new QueryWithParameter();
        app.getActor("Sudeep");
    }

}
