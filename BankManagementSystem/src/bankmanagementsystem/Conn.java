/* 1. Register the driver
2. Create connection
3. create statement
4. execute query
close connection
*/
package bankmanagementsystem;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn() {
        try {
                      
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem" , "root","vibhor");
            s = c.createStatement();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
    
}
}
