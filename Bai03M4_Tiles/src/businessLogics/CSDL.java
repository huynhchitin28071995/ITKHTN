package businessLogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSDL {
	private static Connection ketNoi;
    public static Connection getKetNoi(){
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/qlbansua?useUnicode=true&characterEncoding=UTF-8";
            ketNoi = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketNoi;
    }
}
