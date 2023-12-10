package bankManagementSystem;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
           c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem", "root" , "mdEhte@&0411");
           s = c.createStatement();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
