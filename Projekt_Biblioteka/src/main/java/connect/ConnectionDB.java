package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {



 static Connection conn = null;
    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","radek","1234");
            if (conn != null){
                System.out.println("Połączono z bazą danych");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return conn;
    }
}
