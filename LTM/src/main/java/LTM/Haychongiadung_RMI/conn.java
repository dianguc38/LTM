package LTM.Haychongiadung_RMI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn {
    public static Connection getConnection(){
        Connection con = null;
        String jdbcUrl="jdbc:mysql://localhost:3306/LTM?serverTimezone=UTC";
        String user = "root";
        String pwd  = "";

        try{
            con = DriverManager.getConnection(jdbcUrl,user,pwd);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
