import java.sql.*;

public class LoginValidate {
    public static boolean checkUser(String id,String password) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","1234");
            PreparedStatement ps = con.prepareStatement("select * from student where id=? and password=?");
            ps.setString(1, id);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}